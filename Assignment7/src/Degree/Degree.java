package Degree;

import CourseCatalog.Course;
import java.util.ArrayList;

public class Degree {
    private String title;
    private ArrayList<Course> coreCourses;
    private ArrayList<Course> electives;

    public Degree(String title) {
        this.title = title;
        this.coreCourses = new ArrayList<>();
        this.electives = new ArrayList<>();
    }

    public void addCoreCourse(Course course) {
        coreCourses.add(course);
    }

    public void addElectiveCourse(Course course) {
        electives.add(course);
    }
}
