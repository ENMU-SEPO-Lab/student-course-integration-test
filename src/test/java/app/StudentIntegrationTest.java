package app;

import org.junit.Test;
import static org.junit.Assert.*;

public class StudentIntegrationTest {

    @Test
    public void testIntegration() {

        CourseRepository repo = new CourseRepository();
        StudentService service = new StudentService(repo);

        Course c = new Course("CS101", "Intro");
        repo.addCourse(c);

        Student s = new Student("Alice");

        service.enrollStudent(s, "CS101");

        assertEquals(1, s.getCourses().size());
        assertEquals("CS101", s.getCourses().get(0).getCourseId());
    }
}