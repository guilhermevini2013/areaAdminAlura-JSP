package org.example.areaadminalurajsp.servlets.post;

import com.google.gson.Gson;
import org.example.areaadminalurajsp.dtos.insert.CourseDTO;
import org.example.areaadminalurajsp.service.content.CourseService;
import org.example.areaadminalurajsp.service.singletons.CourseServiceSingleton;
import org.example.areaadminalurajsp.servlets.IController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CourseForm implements IController {
    private CourseService courseService = CourseServiceSingleton.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String token = (String) request.getSession().getAttribute("token");
        Gson gson = new Gson();
        String json = request.getReader().readLine();
        CourseDTO course = gson.fromJson(json, CourseDTO.class);
        String inf = courseService.addCourse(course, token);
        request.setAttribute("messageInf", inf);
        return "redirect:courses?action=Courses";
    }
}
