/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseCatalog;

import java.util.ArrayList;

public class CourseCatalog {
    private ArrayList<Course> courses;

    public CourseCatalog() {
        courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}
