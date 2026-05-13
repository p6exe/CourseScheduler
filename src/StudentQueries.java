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
public class StudentQueries {
    private static Connection connection;
    private static PreparedStatement addStudent;
    private static PreparedStatement getStudentList;
    private static PreparedStatement getStudent;
    private static PreparedStatement dropStudent;
    private static ResultSet resultset;
    private static StudentEntry Student;
    
    public static void addStudent(StudentEntry student) {
        connection = DBConnection.getConnection();
        try {
            addStudent = connection.prepareStatement("insert into app.student (studentid, firstname, lastname) values (?, ?, ?)");
            addStudent.setString(1, student.getStudentID());
            addStudent.setString(2, student.getFirstname());
            addStudent.setString(3, student.getLastname());
            addStudent.executeUpdate();
        } catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    public static ArrayList<StudentEntry> getAllStudents() {
        ArrayList<StudentEntry> students = new ArrayList<StudentEntry>();
        connection = DBConnection.getConnection();
        try
        {
            getStudentList = connection.prepareStatement("select studentid, firstname, lastname from app.student");
            resultset = getStudentList.executeQuery();
            while(resultset.next())
            {
                students.add(new StudentEntry(resultset.getString(1), resultset.getString(2), resultset.getString(3)));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return students;
    }
    
    public static StudentEntry getStudent(String studentID) {
        
        connection = DBConnection.getConnection();
        try
        {
            
            getStudent = connection.prepareStatement("select studentid, firstname, lastname from app.student where studentid = ?");
            getStudent.setString(1, studentID);
            resultset = getStudent.executeQuery();
            
            while (resultset.next()) {
                Student = new StudentEntry(resultset.getString(1), resultset.getString(2), resultset.getString(3));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return Student;        
    }
    
    public static void dropStudent(String studentID) {
        connection = DBConnection.getConnection();
        try
        {
            dropStudent = connection.prepareStatement("DELETE FROM app.student WHERE studentid = ?");
            dropStudent.setString(1, studentID);
            dropStudent.executeQuery();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
}
