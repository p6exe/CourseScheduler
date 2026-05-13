/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author rmh6237
 */
public class ScheduleQueries {
    private static Connection connection;
    private static PreparedStatement addSchedule;
    private static PreparedStatement getScheduleList;
    private static PreparedStatement getStudentCountList;
    private static PreparedStatement dropSchedule;
    private static PreparedStatement updateSchedule;
    private static ResultSet resultset;
    
    public static void addScheduleEntry(ScheduleEntry entry) {
        connection = DBConnection.getConnection();
        try {
            addSchedule = connection.prepareStatement("insert into app.schedule (semester, coursecode, studentid, status, timestamp) values (?, ?, ?, ?, ?)");
            addSchedule.setString(1, entry.getSemester());
            addSchedule.setString(2, entry.getCoursecode());
            addSchedule.setString(3, entry.getStudentID());
            addSchedule.setString(4, entry.getStatus());
            addSchedule.setTimestamp(5, entry.getTimestamp());
            addSchedule.executeUpdate();
            
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    
    public static ArrayList<ScheduleEntry> getScheduleByStudent(String semester, String studentID) {
        connection = DBConnection.getConnection();
        ArrayList<ScheduleEntry> Schedules = new ArrayList<ScheduleEntry>();
        try
        {
            getScheduleList = connection.prepareStatement("select coursecode, status, timestamp from app.schedule where semester = ? and studentid = ?");
            getScheduleList.setString(1, semester);
            getScheduleList.setString(2, studentID);
            resultset = getScheduleList.executeQuery();
            
            while (resultset.next()) {
                Schedules.add(new ScheduleEntry(semester,resultset.getString(1), studentID, resultset.getString(2), resultset.getTimestamp(3)));
            }
            
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return Schedules;
    }
    
    public static int getScheduledStudentCount(String currentSemester,String courseCode) {
        connection = DBConnection.getConnection();
        
        int count = 0;
        try
        {
            getStudentCountList = connection.prepareStatement("select COUNT(studentid) from app.schedule where semester = ? and coursecode = ?");
            getStudentCountList.setString(1, currentSemester);
            getStudentCountList.setString(2, courseCode);
            resultset = getStudentCountList.executeQuery();
            
            while (resultset.next()) {
                 count = resultset.getInt(1);
            }
            
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return count;
    }
    
    ///
    public static ArrayList<ScheduleEntry> getScheduledStudentsByCourse(String semester, String courseCode) {
        connection = DBConnection.getConnection();
        ArrayList<ScheduleEntry> Schedules = new ArrayList<ScheduleEntry>();
        try
        {
            getScheduleList = connection.prepareStatement("select studentID, timestamp from app.schedule where semester = ? and coursecode = ? and status = ? order by timestamp");
            getScheduleList.setString(1, semester);
            getScheduleList.setString(2, courseCode);
            getScheduleList.setString(3, "S");
            resultset = getScheduleList.executeQuery();
            
            while (resultset.next()) {
                Schedules.add(new ScheduleEntry(semester, courseCode, resultset.getString(1), "S", resultset.getTimestamp(2)));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return Schedules;
    }
    
    public static ArrayList<ScheduleEntry> getWaitlistedStudentsByCourse(String semester, String courseCode) {
        connection = DBConnection.getConnection();
        ArrayList<ScheduleEntry> Schedules = new ArrayList<ScheduleEntry>();
        try
        {
            getScheduleList = connection.prepareStatement("select studentID, timestamp from app.schedule where semester = ? and coursecode = ? and status = ? order by timestamp");
            getScheduleList.setString(1, semester);
            getScheduleList.setString(2, courseCode);
            getScheduleList.setString(3, "W");
            resultset = getScheduleList.executeQuery();
            
            while (resultset.next()) {
                Schedules.add(new ScheduleEntry(semester, courseCode, resultset.getString(1), "W", resultset.getTimestamp(2)));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return Schedules;
    }
    
    public static void dropStudentScheduleByCourse(String semester, String studentID, String courseCode) {
        connection = DBConnection.getConnection();
        try
        {
            dropSchedule = connection.prepareStatement("delete from app.schedule where semester = ? and studentid = ? and coursecode = ?");
            dropSchedule.setString(1, semester);
            dropSchedule.setString(2, studentID);
            dropSchedule.setString(3, courseCode);
            dropSchedule.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
    
    public static void dropScheduleByCourse(String semester, String courseCode) {
        connection = DBConnection.getConnection();
        try
        {
            dropSchedule = connection.prepareStatement("delete from app.schedule where semester = ? and coursecode = ?");
            dropSchedule.setString(1, semester);
            dropSchedule.setString(2, courseCode);
            dropSchedule.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
    
    public static void updateScheduleEntry(String semester, ScheduleEntry entry) {
        connection = DBConnection.getConnection();
        try
        {
            updateSchedule = connection.prepareStatement("update app.schedule set status = 'S' where semester = ? and studentid = ? and coursecode = ?");
            updateSchedule.setString(1, semester);
            updateSchedule.setString(2, entry.getStudentID());
            updateSchedule.setString(3, entry.getCoursecode());
            updateSchedule.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
}
