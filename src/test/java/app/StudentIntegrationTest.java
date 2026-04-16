package app;

import org.junit.Test;
import static org.junit.Assert.*;

public class StudentIntegrationTest {

    @Test
    public void testIntegration() {

        CourseRepository repo = new CourseRepository();
        StudentService service = new StudentService(repo);

        Course c = new Course("CSCI472", "Software Engineering");
        repo.addCourse(c);

        Student s = new Student("John Wick");

        service.enrollStudent(s, "CSCI472 Software Engineering");

        assertEquals(1, s.getCourses().size());
        assertEquals("CSCI472", s.getCourses().get(0).getCourseId());
    }
}