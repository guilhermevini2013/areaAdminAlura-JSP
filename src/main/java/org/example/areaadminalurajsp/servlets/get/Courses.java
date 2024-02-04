package org.example.areaadminalurajsp.servlets.get;

import org.example.areaadminalurajsp.service.course.CourseService;
import org.example.areaadminalurajsp.service.singletons.CourseServiceSingleton;
import org.example.areaadminalurajsp.servlets.IController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Courses implements IController {
    private CourseService courseService = CourseServiceSingleton.getInstance();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "forward:courses.jsp";
    }
}
