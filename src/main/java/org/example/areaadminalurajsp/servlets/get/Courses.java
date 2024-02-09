package org.example.areaadminalurajsp.servlets.get;

import org.example.areaadminalurajsp.service.content.CategoryService;
import org.example.areaadminalurajsp.service.content.CourseService;
import org.example.areaadminalurajsp.service.singletons.CategoryServiceSingleton;
import org.example.areaadminalurajsp.service.singletons.CourseServiceSingleton;
import org.example.areaadminalurajsp.servlets.IController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Courses implements IController {
    private CourseService courseService = CourseServiceSingleton.getInstance();
    private CategoryService categoryService = CategoryServiceSingleton.getInstance();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String token = (String) request.getSession().getAttribute("token");
        request.setAttribute("listCategories",categoryService.getAllCategories(token));
        return "forward:courses.jsp";
    }
}
