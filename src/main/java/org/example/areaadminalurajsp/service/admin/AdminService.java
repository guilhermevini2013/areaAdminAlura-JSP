package org.example.areaadminalurajsp.service.admin;

import org.example.areaadminalurajsp.connections.api.admin.AdminConnection;
import org.example.areaadminalurajsp.dtos.read.StudentBlockedReadDTO;
import org.example.areaadminalurajsp.dtos.read.StudentReadDTO;

import java.io.IOException;
import java.util.List;

public class AdminService {
    private AdminConnection adminConnection;

    public AdminService(AdminConnection adminConnection) {
        this.adminConnection = adminConnection;
    }

    public List<StudentReadDTO> getAllStudent(Integer page, String token) throws IOException {
        return adminConnection.getAllStudentUnBlocked(page, token);
    }

    public List<StudentBlockedReadDTO> getAllStudentBlocked(Integer page, String token) throws IOException {
        return adminConnection.getAllStudentBlocked(page, token);
    }

    public String blockStudent(Long id, Integer time, String token) throws IOException {
        return adminConnection.blockStudent(id, time, token);
    }

    public String unblockStudent(Long id, String token) throws IOException {
        return adminConnection.unBlockStudent(id, token);
    }

    public List<StudentReadDTO> getStudentByFilter(String name,String typeStudent, String token) throws IOException {
        return adminConnection.getStudentByFilter(name,typeStudent, token);
    }

}
