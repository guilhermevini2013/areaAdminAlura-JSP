package org.example.areaadminalurajsp.servlets.get;

import com.google.gson.Gson;
import org.example.areaadminalurajsp.service.admin.AdminService;
import org.example.areaadminalurajsp.service.singletons.AdminServiceSingleton;
import org.example.areaadminalurajsp.servlets.IController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListedStudent implements IController {
    private AdminService adminService = AdminServiceSingleton.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImFkbWluQGFkbWluIiwiZXhwIjoxNzA2NTMwMzg2fQ.JeyLGqRaioa6V9jjlKCHFlxPE2Y8m6VZu9RhpAt3Ytc";
        String json = new Gson().toJson(adminService.getAllStudent(getPageParam(request), token));
        response.getWriter().write(json);
        return null;
    }

    private Integer getPageParam(HttpServletRequest req) {
        String page = req.getParameter("page");
        return Integer.valueOf(page);
    }
}
