/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */package CourseSchedule;

import java.util.ArrayList;
import CourseSchedule.Seat;
import CourseSchedule.CourseOffer;

public class CourseLoad {
    private String semester;
    private ArrayList<SeatAssignment> seatAssignments;

    public CourseLoad(String semester) {
        this.semester = semester;
        this.seatAssignments = new ArrayList<>();
    }

    public float getTotalSemesterScore() {
        float totalScore = 0;
        for (SeatAssignment sa : seatAssignments) {
            totalScore += sa.getCourseScore();
        }
        return totalScore;
    }

    public ArrayList<SeatAssignment> getSeatAssignments() {
        return seatAssignments;
    }

    public void addSeatAssignment(CourseOffer is101Offer) {
    }
}