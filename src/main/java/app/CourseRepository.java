package app;

import java.util.HashMap;
import java.util.Map;

public class CourseRepository {
    private Map<String, Course> db = new HashMap<>();

    public void addCourse(Course c) {
        db.put(c.getCourseId(), c);
    }

    public Course findCourseById(String id) {
        return db.get(id);
    }
}