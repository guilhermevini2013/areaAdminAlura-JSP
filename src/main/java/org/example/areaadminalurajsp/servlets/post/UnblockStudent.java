package org.example.areaadminalurajsp.servlets.post;

import org.example.areaadminalurajsp.service.admin.AdminService;
import org.example.areaadminalurajsp.service.singletons.AdminServiceSingleton;
import org.example.areaadminalurajsp.service.util.ControllerUtil;
import org.example.areaadminalurajsp.servlets.IController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UnblockStudent implements IController {
    private AdminService adminService = AdminServiceSingleton.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String token = (String) request.getSession().getAttribute("token");
        if (token == null){
            return "redirect:login?action=Login";
        }
        String idStudent = request.getParameter("idStudent");
        adminService.unblockStudent(Long.valueOf(idStudent), token);
        return "redirect:student?action=Student";
    }
}
