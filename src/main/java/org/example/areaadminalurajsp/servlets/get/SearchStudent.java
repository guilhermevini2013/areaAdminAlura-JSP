package org.example.areaadminalurajsp.servlets.get;

import com.google.gson.Gson;
import org.example.areaadminalurajsp.service.admin.AdminService;
import org.example.areaadminalurajsp.service.singletons.AdminServiceSingleton;
import org.example.areaadminalurajsp.servlets.IController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SearchStudent implements IController {
    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImFkbWluQGFkbWluIiwiZXhwIjoxNzA2NDkxODY1fQ.x3VTIIot5q2yC-qztfWNuk6SahxcoiLxa92xHweMT0M";

    private AdminService adminService = AdminServiceSingleton.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String typeStudent = request.getParameter("typeStudent");
        String json = new Gson().toJson(adminService.getStudentByFilter(name,typeStudent, token));
        response.getWriter().write(json);
        return null;
    }
}
