package CourseSchedule;

import CourseCatalog.CourseCatalog;
import java.util.ArrayList;

import CourseCatalog.Course;

public class CourseSchedule {
    private String semester;
    private ArrayList<CourseOffer> courseOffers;
    private CourseCatalog courseCatalog; // Add CourseCatalog reference

    // Updated constructor
    public CourseSchedule(String semester, CourseCatalog courseCatalog) {
        this.semester = semester;
        this.courseCatalog = courseCatalog;
        this.courseOffers = new ArrayList<>();
    }

    public CourseOffer addCourseOffer(Course course, int numberOfSeats) {
        CourseOffer courseOffer = new CourseOffer(course, numberOfSeats);
        courseOffers.add(courseOffer);
        return courseOffer;
    }

    public ArrayList<CourseOffer> getCourseOffers() {
        return courseOffers;
    }

    public int calculateTotalRevenues() {
        int totalRevenue = 0;
        for (CourseOffer offer : courseOffers) {
            totalRevenue += offer.getCourse().getCoursePrice() * offer.getSeats().size();
        }
        return totalRevenue;
    }
}
