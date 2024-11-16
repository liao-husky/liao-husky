/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseSchedule;

public class SeatAssignment {
    private Seat seat;
    private CourseLoad courseLoad;
    private float grade;
    private boolean likedCourse;

    public SeatAssignment(Seat seat, CourseLoad courseLoad) {
        this.seat = seat;
        this.courseLoad = courseLoad;
    }
    public float getCourseScore() {

        return grade;
    }

    public void setGrade(float grade) {

        this.grade = grade;
    }

    public void setLikedCourse(boolean likedCourse) {

        this.likedCourse = likedCourse;
    }

    public boolean isLikedCourse() {

        return likedCourse;
    }

    public CourseOffer getCourseOffer() { // 从 Seat 获取 CourseOffer

        return seat.getCourseOffer();
    }
}
