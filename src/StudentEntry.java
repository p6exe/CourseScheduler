/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rmh6237
 */
public class StudentEntry {
    private final String studentID;
    private final String firstname;
    private final String lastname;
    public StudentEntry(String studentID, String firstname, String lastname) {
        this.studentID = studentID;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    public String getStudentID() {
        return studentID;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
}
