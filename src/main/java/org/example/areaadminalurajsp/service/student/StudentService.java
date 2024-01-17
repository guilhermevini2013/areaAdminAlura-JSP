package org.example.areaadminalurajsp.service.student;

import org.example.areaadminalurajsp.connections.api.admin.AdminConnection;
import org.example.areaadminalurajsp.dtos.read.StudentReadDTO;

import java.io.IOException;
import java.util.List;

public class StudentService {
    private AdminConnection adminConnection;

    public StudentService(AdminConnection adminConnection) {
        this.adminConnection = adminConnection;
    }

    public List<StudentReadDTO> getAllStudent(Integer page, String token) throws IOException {
        return adminConnection.getAllStudentUnBlocked(page, token);
    }
}
