package org.example.areaadminalurajsp.servlets.student.blocked;

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

@WebServlet(value = "/listStudentBlocked")
public class ListStudentBlockedServlets extends HttpServlet {
    private AdminService adminService;
    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImFkbWluQGFkbWluIiwiZXhwIjoxNzA1ODg0MDk1fQ.tSHp0O0L4MszW4J6RizsJLfXeSLkfgu7fuIKtWJMk44";

    @Override
    public void init() throws ServletException {
        Gson gson = new Gson();
        ConnectionInitializer initializer = new ConnectionInitializer(HttpClients.createDefault(), gson);
        AdminConnection adminConnection = new AdminConnection(initializer);
        adminService = new AdminService(adminConnection);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = new Gson().toJson(adminService.getAllStudentBlocked(getPageParam(req), token));
        System.out.println(json);
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStudent = req.getParameter("idStudent");
        adminService.unblockStudent(Long.valueOf(idStudent),token);
        resp.sendRedirect("student");
    }

    private Integer getPageParam(HttpServletRequest req) {
        String page = req.getParameter("page");
        return Integer.valueOf(page);
    }
}