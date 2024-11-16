/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Department;

import CourseCatalog.CourseCatalog;
import CourseSchedule.CourseSchedule;
import Persona.StudentDirectory;
import java.util.ArrayList;

public class Department {
    private String name;
    private CourseCatalog courseCatalog;
    private StudentDirectory studentDirectory;
    private ArrayList<CourseSchedule> courseSchedules;

    public Department(String name, StudentDirectory studentDirectory) {
        this.name = name;
        this.courseCatalog = new CourseCatalog();
        this.studentDirectory = studentDirectory;
        this.courseSchedules = new ArrayList<>();
    }

    public CourseCatalog getCourseCatalog() {
        return courseCatalog;
    }

    public CourseSchedule createCourseSchedule(String semester) {
        CourseSchedule schedule = new CourseSchedule(semester, courseCatalog);
        courseSchedules.add(schedule);
        return schedule;
    }

    public String getName() {
        return name; 
    }
}
