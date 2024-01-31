package org.example.areaadminalurajsp;

import org.example.areaadminalurajsp.dtos.read.LoginAdmin;
import org.example.areaadminalurajsp.service.admin.AdminService;
import org.example.areaadminalurajsp.service.singletons.AdminServiceSingleton;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        AdminService adminService = AdminServiceSingleton.getInstance();
        System.out.println(adminService.loginAdmin(new LoginAdmin("admin@admin","admin")));;
    }
}
