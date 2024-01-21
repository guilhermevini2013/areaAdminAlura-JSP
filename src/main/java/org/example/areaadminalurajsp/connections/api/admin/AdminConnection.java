package org.example.areaadminalurajsp.connections.api.admin;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.example.areaadminalurajsp.connections.ConnectionInitializer;
import org.example.areaadminalurajsp.dtos.read.StudentBlockedReadDTO;
import org.example.areaadminalurajsp.dtos.read.StudentReadDTO;

import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

public class AdminConnection {
    private ConnectionInitializer initializer;

    public AdminConnection(ConnectionInitializer initializer) {
        this.initializer = initializer;
    }

    public List<StudentReadDTO> getAllStudentUnBlocked(Integer page, String token) throws IOException {
        URI uri = URI.create("http://localhost:8080/admin/unblocked?pages=" + page);
        CloseableHttpResponse response = initializer.doGetRequest(uri, token);
        String json = EntityUtils.toString(response.getEntity());
        StudentReadDTO[] studentReadDTOS = initializer.getGson().fromJson(getContent(json), StudentReadDTO[].class);
        return Arrays.stream(studentReadDTOS).toList();
    }

    public List<StudentBlockedReadDTO> getAllStudentBlocked(Integer page, String token) throws IOException {
        URI uri = URI.create("http://localhost:8080/admin/blocked?pages=" + page);
        CloseableHttpResponse response = initializer.doGetRequest(uri, token);
        String json = EntityUtils.toString(response.getEntity());
        StudentBlockedReadDTO[] studentBlockedReadDTO = initializer.getGson().fromJson(getContent(json), StudentBlockedReadDTO[].class);
        return Arrays.stream(studentBlockedReadDTO).toList();
    }

    public String blockStudent(Long id,Integer time, String token) throws IOException {
        URI uri = URI.create("http://localhost:8080/admin/block/"+id+"?timeInHours="+time);
        CloseableHttpResponse response = initializer.doPostRequest(uri, token);
        return EntityUtils.toString(response.getEntity());
    }
    public String unBlockStudent(Long id,String token) throws IOException {
        URI uri = URI.create("http://localhost:8080/admin/unblock/"+id);
        CloseableHttpResponse response = initializer.doPostRequest(uri, token);
        return EntityUtils.toString(response.getEntity());
    }

    private JsonArray getContent(String json) {
        JsonObject jsonObject = initializer.getGson().fromJson(json, JsonObject.class);
        return jsonObject.getAsJsonArray("content");
    }

}
