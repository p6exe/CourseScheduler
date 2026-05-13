/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Timestamp;

/**
 *
 * @author rmh6237
 */
public class ScheduleEntry {
    private final String semester;
    private final String coursecode;
    private final String studentID;
    private final String status; //"S" or "W"
    private Timestamp timestamp;
    
    public ScheduleEntry(String semester, String course, String studentID, String status, Timestamp timestamp) {
        this.semester = semester;
        this.coursecode = course;
        this.studentID = studentID;
        this.status = status;
        this.timestamp = timestamp;
    }
    
    public String getSemester() {
        return semester;
    }
    public String getCoursecode() {
        return coursecode;
    }
    public String getStudentID() {
         return studentID;
    }
    public String getStatus() {
        return status;
    }
    public Timestamp getTimestamp() {
        return timestamp;
    }
}

