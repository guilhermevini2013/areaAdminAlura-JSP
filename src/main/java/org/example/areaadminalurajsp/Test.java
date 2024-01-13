package org.example.areaadminalurajsp;

import org.example.areaadminalurajsp.connections.api.course.CourseConnection;
import org.example.areaadminalurajsp.dtos.insert.CertificateDTO;
import org.example.areaadminalurajsp.dtos.insert.CourseDTO;
import org.example.areaadminalurajsp.dtos.insert.VideoLessonDTO;

import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        CourseConnection connection = new CourseConnection();
        String token  = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImFkbWluQGFkbWluIiwiZXhwIjoxNzA1MTY2NjI4fQ.pTzMsQ30kxI2qpuj_rnySkzdCcU-agPrgd5EFjK1WEY";
//        CourseDTO courseDTO = new CourseDTO("Curso em video222222222222","Curso em video222222222222", List.of(new VideoLessonDTO("javaaaaaaaaaa","youtube.com//",5)),
//                new CertificateDTO("seilaaakfdaldadkdkldlakld"));
//        connection.postCourse(courseDTO,token);
        System.out.println(connection.getAllCourseByFilter("","","2",token));
    }
}
