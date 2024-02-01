package org.example.areaadminalurajsp.servlets.get;

import org.example.areaadminalurajsp.dtos.read.StudentBlockedReadDTO;
import org.example.areaadminalurajsp.dtos.read.StudentReadDTO;
import org.example.areaadminalurajsp.service.admin.AdminService;
import org.example.areaadminalurajsp.service.singletons.AdminServiceSingleton;
import org.example.areaadminalurajsp.service.util.ControllerUtil;
import org.example.areaadminalurajsp.servlets.IController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Student implements IController {
    private AdminService adminService = AdminServiceSingleton.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String token = (String) request.getSession().getAttribute("token");
        if (token == null){
            return "redirect:login?action=Login";
        }
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
