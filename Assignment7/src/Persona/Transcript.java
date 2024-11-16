/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona;
import CourseSchedule.CourseLoad;
import CourseSchedule.SeatAssignment;
import java.util.ArrayList;
import java.util.HashMap;

public class Transcript {
    private StudentProfile student;
    private HashMap<String, CourseLoad> courseLoadMap;
    private CourseLoad currentCourseLoad;

    public Transcript(StudentProfile student) {
        this.student = student;
        this.courseLoadMap = new HashMap<>();
    }

    public CourseLoad newCourseLoad(String semester) {
        currentCourseLoad = new CourseLoad(semester);
        courseLoadMap.put(semester, currentCourseLoad);
        return currentCourseLoad;
    }

    public CourseLoad getCourseLoadBySemester(String semester) {
        return courseLoadMap.get(semester);
    }

    public ArrayList<SeatAssignment> getCourseList() {
        ArrayList<SeatAssignment> allCourses = new ArrayList<>();
        for (CourseLoad courseLoad : courseLoadMap.values()) {
            allCourses.addAll(courseLoad.getSeatAssignments());
        }
        return allCourses;
    }
}