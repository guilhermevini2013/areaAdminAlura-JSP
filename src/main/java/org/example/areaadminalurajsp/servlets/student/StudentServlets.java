package org.example.areaadminalurajsp.servlets.student;

import com.google.gson.Gson;
import org.apache.http.impl.client.HttpClients;
import org.example.areaadminalurajsp.connections.ConnectionInitializer;
import org.example.areaadminalurajsp.connections.api.admin.AdminConnection;
import org.example.areaadminalurajsp.dtos.read.StudentBlockedReadDTO;
import org.example.areaadminalurajsp.dtos.read.StudentReadDTO;
import org.example.areaadminalurajsp.service.admin.AdminService;

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
    private AdminService adminService;

    @Override
    public void init() throws ServletException {
        Gson gson = new Gson();
        ConnectionInitializer initializer = new ConnectionInitializer(HttpClients.createDefault(), gson);
        AdminConnection adminConnection = new AdminConnection(initializer);
        adminService = new AdminService(adminConnection);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImFkbWluQGFkbWluIiwiZXhwIjoxNzA1ODg0MDk1fQ.tSHp0O0L4MszW4J6RizsJLfXeSLkfgu7fuIKtWJMk44";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/studentSection.jsp");
        insertStudentUnblockedRequest(req, token);
        insertStudentBlockedRequest(req, token);
        requestDispatcher.forward(req, resp);
    }

    private void insertStudentUnblockedRequest(HttpServletRequest request, String token) throws IOException {
        List<StudentReadDTO> allStudent = adminService.getAllStudent(0, token);
        request.setAttribute("allStudentUnblock", allStudent);
    }

    private void insertStudentBlockedRequest(HttpServletRequest request, String token) throws IOException {
        List<StudentBlockedReadDTO> allStudent = adminService.getAllStudentBlocked(0, token);
        request.setAttribute("allStudentBlock", allStudent);
    }
}
