/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rmh6237
 */
public class CourseEntry {
    private final String semester;
    private final String coursecode;
    private final String description;
    private final int seats;
    
    public CourseEntry(String semester, String coursecode, String description, int seats) {
        this.semester = semester;
        this.coursecode = coursecode;
        this.description = description;
        this.seats = seats;
    }
    
    public String getSemester() {
        return this.semester;
    }
    public String getCoursecode() {
        return this.coursecode;
    }
    public String getDescription() {
        return this.description;
    }
    public int getSeats() {
        return this.seats;
    }
}
