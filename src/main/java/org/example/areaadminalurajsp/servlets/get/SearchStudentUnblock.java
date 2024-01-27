package org.example.areaadminalurajsp.servlets.get;

import com.google.gson.Gson;
import org.example.areaadminalurajsp.service.admin.AdminService;
import org.example.areaadminalurajsp.service.singletons.AdminServiceSingleton;
import org.example.areaadminalurajsp.servlets.IController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SearchStudentUnblock implements IController {
    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImFkbWluQGFkbWluIiwiZXhwIjoxNzA2NDMzNjIxfQ.WbjiLvLkdvU9xHc20-_DP4qooZOwOsJ-K-T-d83PizM";

    private AdminService adminService = AdminServiceSingleton.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String json = new Gson().toJson(adminService.getStudentByFilter(name, token));
        response.getWriter().write(json);
        return null;
    }
}
