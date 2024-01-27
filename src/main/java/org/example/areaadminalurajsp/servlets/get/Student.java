package org.example.areaadminalurajsp.servlets.get;

import com.google.gson.Gson;
import org.apache.http.impl.client.HttpClients;
import org.example.areaadminalurajsp.connections.ConnectionInitializer;
import org.example.areaadminalurajsp.connections.api.admin.AdminConnection;
import org.example.areaadminalurajsp.dtos.read.StudentBlockedReadDTO;
import org.example.areaadminalurajsp.dtos.read.StudentReadDTO;
import org.example.areaadminalurajsp.service.admin.AdminService;
import org.example.areaadminalurajsp.servlets.IController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Student implements IController {
    private AdminService adminService;

    {
        Gson gson = new Gson();
        ConnectionInitializer initializer = new ConnectionInitializer(HttpClients.createDefault(), gson);
        AdminConnection adminConnection = new AdminConnection(initializer);
        adminService = new AdminService(adminConnection);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImFkbWluQGFkbWluIiwiZXhwIjoxNzA2MzU1OTA3fQ.LWjY8bS2XrYmsLBrGg3OuyAg7Ql4sNuafeGdEr9hYqA";
        insertStudentUnblockedRequest(request, token);
        insertStudentBlockedRequest(request, token);
        return "forward:studentSection.jsp";
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
