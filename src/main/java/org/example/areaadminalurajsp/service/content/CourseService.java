package org.example.areaadminalurajsp.service.content;

import org.example.areaadminalurajsp.connections.api.content.CourseConnection;
import org.example.areaadminalurajsp.dtos.insert.CourseDTO;

import java.io.IOException;

public class CourseService {
    private CourseConnection courseConnection;

    public CourseService(CourseConnection courseConnection) {
        this.courseConnection = courseConnection;
    }

    public String addCourse(CourseDTO courseDTO, String token) throws IOException {
        courseConnection.postCourse(courseDTO, token);
        return "Course Adding successful";
    }
}
