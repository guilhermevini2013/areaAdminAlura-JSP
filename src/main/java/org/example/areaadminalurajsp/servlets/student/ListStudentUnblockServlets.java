package org.example.areaadminalurajsp.servlets.student;

import org.example.areaadminalurajsp.service.student.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/ListStudentUnblock")
public class ListStudentUnblockServlets extends HttpServlet {
    private StudentService studentService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer page = Integer.valueOf(req.getParameter("page"));
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImFkbWluQGFkbWluIiwiZXhwIjoxNzA1NTM3NzkzfQ.hF4sysZy-gbGpjZLfuaOQBno0ovuI7Lhk1pt9SUiQJs";
        studentService.getAllStudent(page,token);
        resp.sendRedirect("student");
    }
}
