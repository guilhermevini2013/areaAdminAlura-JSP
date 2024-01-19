package org.example.areaadminalurajsp.servlets.student;

import com.google.gson.Gson;
import org.apache.http.impl.client.HttpClients;
import org.example.areaadminalurajsp.connections.ConnectionInitializer;
import org.example.areaadminalurajsp.connections.api.admin.AdminConnection;
import org.example.areaadminalurajsp.service.student.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/listStudentUnblocked")
public class ListStudentsServlets extends HttpServlet {
    private StudentService studentService;

    {
        Gson gson = new Gson();
        ConnectionInitializer initializer = new ConnectionInitializer(HttpClients.createDefault(), gson);
        AdminConnection adminConnection = new AdminConnection(initializer);
        studentService = new StudentService(adminConnection);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImFkbWluQGFkbWluIiwiZXhwIjoxNzA1NjQ3OTQ1fQ.O7Cf2BobVxOR5aJ0E6ERT3DrR3rQDr2WE3m6oqyUI6I";
        String json = new Gson().toJson(studentService.getAllStudent(getPageParam(req), token));
        resp.getWriter().write(json);
    }

    private Integer getPageParam(HttpServletRequest req) {
        String page = req.getParameter("page");
        return Integer.valueOf(page);
    }
}
