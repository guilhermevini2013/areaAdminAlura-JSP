package org.example.areaadminalurajsp;

import com.google.gson.Gson;
import org.apache.http.impl.client.HttpClients;
import org.example.areaadminalurajsp.connections.ConnectionInitializer;
import org.example.areaadminalurajsp.connections.api.dashboard.DashboardConnection;
import org.example.areaadminalurajsp.dtos.read.DashBoardReadDTO;

import java.io.IOException;
import java.net.http.HttpClient;

public class Test {
    public static void main(String[] args) throws IOException {
        DashboardConnection connection = new DashboardConnection(new ConnectionInitializer(HttpClients.createDefault(),new Gson()));
        String token  = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImFkbWluQGFkbWluIiwiZXhwIjoxNzA1NDMwMjUxfQ.zOJa5A363KcDvSiUwC_jQFmvU_BxwWF1fbSs-fmRGuw";
//        CourseDTO courseDTO = new CourseDTO("Curso em video222222222222","Curso em video222222222222", List.of(new VideoLessonDTO("javaaaaaaaaaa","youtube.com//",5)),
//                new CertificateDTO("seilaaakfdaldadkdkldlakld"));
//        connection.postCourse(courseDTO,token);
//        System.out.println(connection.getAllCourseByFilter("","","2",token));
        DashBoardReadDTO dashboard = connection.getDashboard(token);
        System.out.println(dashboard.getTotalCourse());
    }
}
