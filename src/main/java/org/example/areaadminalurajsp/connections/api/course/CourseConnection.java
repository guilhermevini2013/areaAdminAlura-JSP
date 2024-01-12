package org.example.areaadminalurajsp.connections.api.course;

import com.google.gson.Gson;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.example.areaadminalurajsp.connections.ConnectionInitializer;
import org.example.areaadminalurajsp.dtos.insert.CourseDTO;

import java.io.IOException;
import java.net.URI;


public class CourseConnection extends ConnectionInitializer {

    public String getCourseByID(Long id,String token) throws IOException {
        URI uriFindAllCourses = URI.create("http://localhost:8080/course/id/"+id);
        CloseableHttpResponse response = doGetRequest(uriFindAllCourses,token);
        return EntityUtils.toString(response.getEntity());
    }
    public String getAllCourse(String token) throws IOException {
        URI uriFindAllCourse = URI.create("http://localhost:8080/course");
        CloseableHttpResponse response = doGetRequest(uriFindAllCourse, token);
        return EntityUtils.toString(response.getEntity());
    }
    public void postCourse(CourseDTO courseDTO,String token) throws IOException {
        URI uriPostCourse = URI.create("http://localhost:8080/course");
        Gson gson = new Gson();
        String json = gson.toJson(courseDTO);
        doPostRequest(uriPostCourse,token,json);
    }
}
