package app;

public class StudentService {

    private CourseRepository repo;

    public StudentService(CourseRepository repo) {
        this.repo = repo;
    }

    public void enrollStudent(Student student, String courseId) {
        Course c = repo.findCourseById(courseId);
        if (c != null) {
            student.enroll(c);
        }
    }
}