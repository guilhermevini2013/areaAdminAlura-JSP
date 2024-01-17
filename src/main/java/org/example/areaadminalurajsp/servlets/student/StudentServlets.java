package org.example.areaadminalurajsp.servlets.student;

import com.google.gson.Gson;
import org.apache.http.impl.client.HttpClients;
import org.example.areaadminalurajsp.connections.ConnectionInitializer;
import org.example.areaadminalurajsp.connections.api.admin.AdminConnection;
import org.example.areaadminalurajsp.connections.api.dashboard.DashboardConnection;
import org.example.areaadminalurajsp.dtos.read.StudentBlockedReadDTO;
import org.example.areaadminalurajsp.dtos.read.StudentReadDTO;
import org.example.areaadminalurajsp.service.dashboard.DashboardService;
import org.example.areaadminalurajsp.service.student.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/student")
public class StudentServlets extends HttpServlet {
    private StudentService studentService;
    {
        Gson gson = new Gson();
        ConnectionInitializer initializer = new ConnectionInitializer(HttpClients.createDefault(), gson);
        AdminConnection adminConnection = new AdminConnection(initializer);
        studentService = new StudentService(adminConnection);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImFkbWluQGFkbWluIiwiZXhwIjoxNzA1NTM3NzkzfQ.hF4sysZy-gbGpjZLfuaOQBno0ovuI7Lhk1pt9SUiQJs";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/studentSection.jsp");
        insertStudentUnblockedRequest(req,token);
        insertStudentBlockedRequest(req,token);
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
    private void insertStudentUnblockedRequest(HttpServletRequest request,String token) throws IOException {
        List<StudentReadDTO> allStudent = studentService.getAllStudent(0, token);
        request.setAttribute("allStudentUnblock",allStudent);
    }
    private void insertStudentBlockedRequest(HttpServletRequest request,String token) throws IOException {
        List<StudentBlockedReadDTO> allStudent = studentService.getAllStudentBlocked(0, token);
        request.setAttribute("allStudentBlock",allStudent);
    }
}
