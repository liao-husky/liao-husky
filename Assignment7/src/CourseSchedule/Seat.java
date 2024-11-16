/* 
* To change this license header, choose License Headers in Project Properties. 
* To change this template file, choose Tools | Templates 
* and open the template in the editor. 
*/ 
package CourseSchedule;

import Persona.Student;

public class Seat {
    private CourseOffer courseOffer;
    private int seatNumber;
    private Student student;

    public Seat(CourseOffer courseOffer, int seatNumber) {
        this.courseOffer = courseOffer;
        this.seatNumber = seatNumber;
    }

    public boolean isOccupied() {
        return student != null;
    }

    public void assignStudent(Student student) {
        this.student = student;
    }

    public CourseOffer getCourseOffer() { // 添加此方法
        return courseOffer;
    }

    public SeatAssignment assignToStudent(CourseLoad courseLoad) {
        SeatAssignment seatAssignment = new SeatAssignment(this, courseLoad);
        return seatAssignment;
    }
}
