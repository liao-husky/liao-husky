import College.College;
import Department.Department;
import CourseCatalog.Course;
import CourseSchedule.CourseSchedule;
import CourseSchedule.CourseOffer;
import Persona.Faculty;
import Persona.Student;
import Persona.StudentDirectory;

public class UniversityExample {
    public static void main(String[] args) {
        // Step 1: Create a College
        College college = new College("Northeastern University College of Engineering");

        // Step 2: Create a shared Student Directory
        StudentDirectory studentDirectory = new StudentDirectory();

        // Step 3: Create Departments
        Department msis = new Department("MSIS", studentDirectory);
        Department msda = new Department("MSDA", studentDirectory);
        college.addDepartment(msis);
        college.addDepartment(msda);

        // Step 4: Add 5 courses to each department
        Course is101 = new Course("IS101", "Data Management", 3);
        Course is102 = new Course("IS102", "Business Analytics", 3);
        Course is103 = new Course("IS103", "Cloud Computing", 3);
        Course is104 = new Course("IS104", "Cybersecurity", 3);
        Course is105 = new Course("IS105", "Software Engineering", 3);
        msis.getCourseCatalog().addCourse(is101);
        msis.getCourseCatalog().addCourse(is102);
        msis.getCourseCatalog().addCourse(is103);
        msis.getCourseCatalog().addCourse(is104);
        msis.getCourseCatalog().addCourse(is105);

        Course da201 = new Course("DA201", "Machine Learning", 3);
        Course da202 = new Course("DA202", "Data Visualization", 3);
        Course da203 = new Course("DA203", "Big Data", 3);
        Course da204 = new Course("DA204", "Predictive Analytics", 3);
        Course da205 = new Course("DA205", "Statistics", 3);
        msda.getCourseCatalog().addCourse(da201);
        msda.getCourseCatalog().addCourse(da202);
        msda.getCourseCatalog().addCourse(da203);
        msda.getCourseCatalog().addCourse(da204);
        msda.getCourseCatalog().addCourse(da205);

        // Step 5: Add 10 students to each department
        for (int i = 1; i <= 10; i++) {
            studentDirectory.addStudent(new Student("MSIS_Student" + i));
            studentDirectory.addStudent(new Student("MSDA_Student" + (i + 10)));
        }

        // Step 6: Create Faculty for each course
        Faculty faculty1 = new Faculty("Dr. Alice", "F001");
        Faculty faculty2 = new Faculty("Dr. Bob", "F002");
        Faculty faculty3 = new Faculty("Dr. Carol", "F003");
        Faculty faculty4 = new Faculty("Dr. David", "F004");
        Faculty faculty5 = new Faculty("Dr. Eve", "F005");

        // Step 7: Create Course Schedules for Fall 2024
        CourseSchedule msisSchedule = msis.createCourseSchedule("Fall 2024");
        CourseSchedule msdaSchedule = msda.createCourseSchedule("Fall 2024");

        // Step 8: Add Course Offerings and assign Faculty
        CourseOffer is101Offer = msisSchedule.addCourseOffer(is101, 15);
        is101Offer.AssignAsTeacher(faculty1);
        CourseOffer is102Offer = msisSchedule.addCourseOffer(is102, 15);
        is102Offer.AssignAsTeacher(faculty2);
        CourseOffer is103Offer = msisSchedule.addCourseOffer(is103, 15);
        is103Offer.AssignAsTeacher(faculty3);
        CourseOffer is104Offer = msisSchedule.addCourseOffer(is104, 15);
        is104Offer.AssignAsTeacher(faculty4);
        CourseOffer is105Offer = msisSchedule.addCourseOffer(is105, 15);
        is105Offer.AssignAsTeacher(faculty5);

        CourseOffer da201Offer = msdaSchedule.addCourseOffer(da201, 15);
        da201Offer.AssignAsTeacher(faculty1);
        CourseOffer da202Offer = msdaSchedule.addCourseOffer(da202, 15);
        da202Offer.AssignAsTeacher(faculty2);
        CourseOffer da203Offer = msdaSchedule.addCourseOffer(da203, 15);
        da203Offer.AssignAsTeacher(faculty3);
        CourseOffer da204Offer = msdaSchedule.addCourseOffer(da204, 15);
        da204Offer.AssignAsTeacher(faculty4);
        CourseOffer da205Offer = msdaSchedule.addCourseOffer(da205, 15);
        da205Offer.AssignAsTeacher(faculty5);

        // Step 9: Register Students for courses
        for (int i = 0; i < 10; i++) {
            Student msisStudent = studentDirectory.getStudents().get(i);
            Student msdaStudent = studentDirectory.getStudents().get(i + 10);

            var msisLoad = msisStudent.getProfile().createCourseLoad("Fall 2024");
            msisLoad.addSeatAssignment(is101Offer);
            msisLoad.addSeatAssignment(is102Offer);
            if (i % 2 == 0) msisLoad.addSeatAssignment(is103Offer);

            var msdaLoad = msdaStudent.getProfile().createCourseLoad("Fall 2024");
            msdaLoad.addSeatAssignment(da201Offer);
            msdaLoad.addSeatAssignment(da202Offer);
            if (i % 2 == 0) msdaLoad.addSeatAssignment(da203Offer);
        }

        // Step 10: Assign Grades
        for (Student student : studentDirectory.getStudents()) {
            for (var seatAssignment : student.getProfile().getAllCourses()) {
                seatAssignment.setGrade(70 + (int) (Math.random() * 30)); // Grades between 70-100
            }
        }


        // Output Results
        System.out.println("College: " + college.getName());
        for (Department department : college.getDepartments()) {
            System.out.println("\nDepartment: " + department.getName());
            for (Course course : department.getCourseCatalog().getCourses()) {
                System.out.println("  Course: " + course.getCourseName());
            }
        }

        System.out.println("\nCourse Schedule for Fall 2024:");
        for (CourseOffer offer : msisSchedule.getCourseOffers()) {
            System.out.println("  MSIS Offering: " + offer.getCourse().getCourseName());
        }
        for (CourseOffer offer : msdaSchedule.getCourseOffers()) {
            System.out.println("  MSDA Offering: " + offer.getCourse().getCourseName());
        }

        System.out.println("\nRegistered Students:");
        for (Student student : studentDirectory.getStudents()) {
            System.out.println("  Student: " + student.getStudentId() + ", Courses:");
            for (var seatAssignment : student.getProfile().getAllCourses()) {
                System.out.println("    - " + seatAssignment.getCourseOffer().getCourse().getCourseName());
            }
        }
    }
}

