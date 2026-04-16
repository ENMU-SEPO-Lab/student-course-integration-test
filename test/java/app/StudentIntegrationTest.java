package test.java.app;

import org.junit.Test;

import main.java.app.Course;
import main.java.app.CourseRepository;
import main.java.app.Student;
import main.java.app.StudentService;

import static org.junit.Assert.*;

public class StudentIntegrationTest {

    @Test
    public void testIntegration() {

        CourseRepository repo = new CourseRepository();
        StudentService service = new StudentService(repo);

        Course csciCourse = new Course("CSCI1210", "Computer Programming Fundamentals");
        repo.addCourse(csciCourse);

        Student student = new Student("John Wick");

        service.enrollStudent(student, "CSCI1210");

        assertEquals(1, student.getCourses().size());
        assertEquals("CSCI1210", student.getCourses().get(0).getCourseId());
    }
}