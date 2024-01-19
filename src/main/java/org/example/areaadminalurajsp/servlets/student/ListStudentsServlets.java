package org.example.areaadminalurajsp.servlets.student;

import com.google.gson.Gson;
import org.apache.http.impl.client.HttpClients;
import org.example.areaadminalurajsp.connections.ConnectionInitializer;
import org.example.areaadminalurajsp.connections.api.admin.AdminConnection;
import org.example.areaadminalurajsp.service.admin.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/listStudentUnblocked")
public class ListStudentsServlets extends HttpServlet {
    private AdminService adminService;

    {
        Gson gson = new Gson();
        ConnectionInitializer initializer = new ConnectionInitializer(HttpClients.createDefault(), gson);
        AdminConnection adminConnection = new AdminConnection(initializer);
        adminService = new AdminService(adminConnection);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImFkbWluQGFkbWluIiwiZXhwIjoxNzA1Njg4NzM3fQ.okXxOLvR7Z_jQAG4zElzB9MPJ9a_K5DAvio_4_9n8hI";
        String json = new Gson().toJson(adminService.getAllStudent(getPageParam(req), token));
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImFkbWluQGFkbWluIiwiZXhwIjoxNzA1Njg4NzM3fQ.okXxOLvR7Z_jQAG4zElzB9MPJ9a_K5DAvio_4_9n8hI";
        String idStudent = req.getParameter("idStudent");
        adminService.blockStudent(Long.valueOf(idStudent),token);
        resp.sendRedirect("student");
    }

    private Integer getPageParam(HttpServletRequest req) {
        String page = req.getParameter("page");
        return Integer.valueOf(page);
    }
}
