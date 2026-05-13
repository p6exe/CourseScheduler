/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author rmh6237
 */
public class CourseQueries {
    private static Connection connection;
    private static PreparedStatement addCourse;
    private static PreparedStatement getCourseList;
    private static PreparedStatement getCourseCodeList;
    private static PreparedStatement getCourseSeatList;
    private static PreparedStatement dropCourseSeatList;
    private static ResultSet resultset;
    
    public static void addCourse(CourseEntry course)
    {
        connection = DBConnection.getConnection();
        
        try
        {
            addCourse = connection.prepareStatement("insert into app.course (semester, coursecode, description, seats) values (?, ?, ?, ?)");
            addCourse.setString(1, course.getSemester());
            addCourse.setString(2, course.getCoursecode());
            addCourse.setString(3, course.getDescription());
            addCourse.setInt(4, course.getSeats());
            addCourse.executeUpdate();
        } catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        
    }

    public static ArrayList<CourseEntry> getAllCourses(String semester) {
        ArrayList<CourseEntry> courses = new ArrayList<CourseEntry>();
        connection = DBConnection.getConnection();
        try
        {
            getCourseList = connection.prepareStatement("select coursecode, description, seats from app.course where semester in (?)");
            getCourseList.setString(1,semester);
            resultset = getCourseList.executeQuery();
            
            while(resultset.next())
            {
                courses.add(new CourseEntry(semester, resultset.getString(1), resultset.getString(2), resultset.getInt(3)));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return courses;
    }
    
    public static ArrayList<String> getAllCourseCodes(String semester) {
        connection = DBConnection.getConnection();
        ArrayList<String> courseCodes = new ArrayList<String>();
        try
        {
            getCourseCodeList = connection.prepareStatement("select coursecode from app.course where semester = ?");
            getCourseCodeList.setString(1, semester);
            resultset = getCourseCodeList.executeQuery();
            
            while(resultset.next())
            {
                courseCodes.add(resultset.getString(1));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return courseCodes;
    }
    
    public static int getCourseSeats(String semester, String courseCode) {
        connection = DBConnection.getConnection();
        int Seats = 0;
        try
        {
            getCourseSeatList = connection.prepareStatement("select seats from app.course where semester = ? and coursecode = ?");
            getCourseSeatList.setString(1, semester);
            getCourseSeatList.setString(2, courseCode);
            resultset = getCourseSeatList.executeQuery();
            
            while(resultset.next()) {
                Seats = resultset.getInt(1);
            }
            
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return Seats;
    
    }
    
    public static void dropCourse(String semester, String courseCode) {
        connection = DBConnection.getConnection();
        try
        {
            dropCourseSeatList = connection.prepareStatement("DELETE FROM app.course WHERE semester = ? and coursecode = ?");
            dropCourseSeatList.setString(1, semester);
            dropCourseSeatList.setString(2, courseCode);
            dropCourseSeatList.executeUpdate();
            
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
}
