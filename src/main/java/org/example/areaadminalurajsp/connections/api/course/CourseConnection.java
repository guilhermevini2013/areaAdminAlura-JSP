package org.example.areaadminalurajsp.connections.api.course;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.example.areaadminalurajsp.connections.ConnectionInitializer;

import java.io.IOException;
import java.net.URI;


public class CourseConnection extends ConnectionInitializer {

    public String getCourseByID(Long id,String token) throws IOException {
        URI uriFindAllCourses = URI.create("http://localhost:8080/course/id/"+id);
        CloseableHttpResponse closeableHttpResponse = doGetRequest(uriFindAllCourses,token);
        return EntityUtils.toString(closeableHttpResponse.getEntity());
    }
}
