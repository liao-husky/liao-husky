/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona.Faculty;

import CourseSchedule.CourseOffer;

public class FacultyAssignment {
    private FacultyProfile facultyProfile;
    private CourseOffer courseOffer;
    private double rating;

    public FacultyAssignment(FacultyProfile facultyProfile, CourseOffer courseOffer) {
        this.facultyProfile = facultyProfile;
        this.courseOffer = courseOffer;
        this.rating = 0.0;
    }

    public FacultyProfile getFacultyProfile() {
        return facultyProfile;
    }

    public CourseOffer getCourseOffer() {
        return courseOffer;
    }

    public double getRating() {
        return rating;
    }
}
