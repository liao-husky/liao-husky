package CourseSchedule;

import CourseCatalog.Course;
import Persona.Faculty;
import java.util.ArrayList;

public class CourseOffer {
    private Course course;
    private ArrayList<Seat> seats;
    private Faculty faculty;  // Store assigned faculty member

    public CourseOffer(Course course, int numberOfSeats) { // Updated constructor
        this.course = course;
        this.seats = new ArrayList<>();
        generateSeats(numberOfSeats);
    }

    private void generateSeats(int numberOfSeats) {
        for (int i = 0; i < numberOfSeats; i++) {
            seats.add(new Seat(this, i));
        }
    }

    public Course getCourse() {
        return course;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    // Add this method to assign a faculty member to the course offering
    public void assignAsTeacher(Faculty faculty) {
        this.faculty = faculty;
    }

    public Faculty getFacultyProfile() {
        return faculty;
    }

    public Seat getAvailableSeat() {
        for (Seat seat : seats) {
            if (!seat.isOccupied()) {
                return seat;
            }
        }
        return null;
    }

    public void AssignAsTeacher(Faculty faculty) {
    }
}
