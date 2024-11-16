/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseCatalog;

import CourseSchedule.CourseOffer;

public class Course {
    private String courseCode;
    private String courseName;
    private int credits;
    private int pricePerCredit = 1500; // Assuming $1500 per credit

    public Course(String courseCode, String courseName, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }

    public String getCourseCode() {

        return courseCode;
    }

    public String getCourseName() {

        return courseName;
    }

    public int getCredits() {

        return credits;
    }

    public int getCoursePrice() {

        return pricePerCredit * credits;
    }
}
