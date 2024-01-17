package org.example.areaadminalurajsp;

import com.google.gson.Gson;
import org.apache.http.impl.client.HttpClients;
import org.example.areaadminalurajsp.connections.ConnectionInitializer;
import org.example.areaadminalurajsp.connections.api.admin.AdminConnection;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        AdminConnection connection = new AdminConnection(new ConnectionInitializer(HttpClients.createDefault(),new Gson()));
        String token  = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImFkbWluQGFkbWluIiwiZXhwIjoxNzA1NTE1NzQyfQ.dVOcY6f7a5WnTPIsNmYkwB0b2dPIAtb2Y5M_9n0eyNs";
//        CourseDTO courseDTO = new CourseDTO("Curso em video222222222222","Curso em video222222222222", List.of(new VideoLessonDTO("javaaaaaaaaaa","youtube.com//",5)),
//                new CertificateDTO("seilaaakfdaldadkdkldlakld"));
//        connection.postCourse(courseDTO,token);
//        System.out.println(connection.getAllCourseByFilter("","","2",token));
        //DashBoardReadDTO dashboard = connection.getDashboard(token);
//        System.out.println(dashboard.getTotalCourse());
        connection.getAllStudentUnBlocked(0,token);
    }
}
