/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona;

import CourseSchedule.CourseLoad;
import CourseSchedule.SeatAssignment;
import java.util.HashMap;
import java.util.ArrayList;

public class StudentProfile {
    private Student student;
    private HashMap<String, CourseLoad> courseLoads;

    public StudentProfile(Student student) {
        this.student = student;
        this.courseLoads = new HashMap<>();
    }

    public CourseLoad createCourseLoad(String semester) {
        CourseLoad courseLoad = new CourseLoad(semester);
        courseLoads.put(semester, courseLoad);
        return courseLoad;
    }

    public CourseLoad getCourseLoad(String semester) {
        return courseLoads.get(semester);
    }

    public float getTotalScore() {
        float totalScore = 0;
        for (CourseLoad cl : courseLoads.values()) {
            totalScore += cl.getTotalSemesterScore();
        }
        return totalScore;
    }

    public ArrayList<SeatAssignment> getAllCourses() {
        ArrayList<SeatAssignment> allCourses = new ArrayList<>();
        for (CourseLoad load : courseLoads.values()) {
            allCourses.addAll(load.getSeatAssignments()); 
        }
        return allCourses;
    }
}