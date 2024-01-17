package org.example.areaadminalurajsp.connections.api.course;

import com.google.gson.Gson;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.example.areaadminalurajsp.connections.ConnectionInitializer;
import org.example.areaadminalurajsp.dtos.insert.CourseDTO;

import java.io.IOException;
import java.net.URI;


public class CourseConnection{
    private ConnectionInitializer connection;

    public CourseConnection(ConnectionInitializer connection) {
        this.connection = connection;
    }

    public String getCourseByID(Long id, String token) throws IOException {
        URI uriFindAllCourses = URI.create("http://localhost:8080/course/id/"+id);
        CloseableHttpResponse response = connection.doGetRequest(uriFindAllCourses,token);
        return EntityUtils.toString(response.getEntity());
    }
    public String getAllCourse(Integer page,String token) throws IOException {
        URI uriFindAllCourse = URI.create("http://localhost:8080/course?pages="+page);
        CloseableHttpResponse response = connection.doGetRequest(uriFindAllCourse, token);
        return EntityUtils.toString(response.getEntity());
    }
    public void postCourse(CourseDTO courseDTO,String token) throws IOException {
        URI uriPostCourse = URI.create("http://localhost:8080/course");
        Gson gson = new Gson();
        String json = gson.toJson(courseDTO);
        connection.doPostRequest(uriPostCourse,token,json);
    }
    public String getAllCourseByFilter(String name,String date,String assessment,String token) throws IOException {
        URI uriAllCourseByFilter = URI.create("http://localhost:8080/course/filter?course="+name+"&publicationDate="+date+"&assessment="+assessment);
        CloseableHttpResponse response = connection.doGetRequest(uriAllCourseByFilter, token);
        return EntityUtils.toString(response.getEntity());
    }
    public void deleteCourseByID(Long id,String token) throws IOException {
        URI uriDeleteCourseByID = URI.create("http://localhost:8080/course/"+id);
        connection.doDeleteRequest(uriDeleteCourseByID, token);
    }
}
