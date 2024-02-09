package org.example.areaadminalurajsp.connections.api.admin;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.example.areaadminalurajsp.connections.ConnectionInitializer;
import org.example.areaadminalurajsp.dtos.error.ErrorModel;
import org.example.areaadminalurajsp.dtos.read.LoginAdmin;
import org.example.areaadminalurajsp.dtos.read.StudentBlockedReadDTO;
import org.example.areaadminalurajsp.dtos.read.StudentReadDTO;
import org.example.areaadminalurajsp.dtos.read.TokenDTO;
import org.example.areaadminalurajsp.exception.BadCredentialsException;

import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

public class AdminConnection {
    private final ConnectionInitializer initializer;

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

    public String blockStudent(Long id, Integer time, String token) throws IOException {
        URI uri = URI.create("http://localhost:8080/admin/block/" + id + "?timeInHours=" + time);
        CloseableHttpResponse response = initializer.doPostRequest(uri, token);
        return EntityUtils.toString(response.getEntity());
    }

    public String unBlockStudent(Long id, String token) throws IOException {
        URI uri = URI.create("http://localhost:8080/admin/unblock/" + id);
        CloseableHttpResponse response = initializer.doPostRequest(uri, token);
        return EntityUtils.toString(response.getEntity());
    }

    public List<StudentReadDTO> getStudentByFilter(String name, String typeStudent, String token) throws IOException {
        URI uri = URI.create("http://localhost:8080/admin/student/filter?name=" + name + "&typeStudent=" + typeStudent);
        CloseableHttpResponse response = initializer.doGetRequest(uri, token);
        String json = EntityUtils.toString(response.getEntity());
        StudentReadDTO[] studentReadDTO = initializer.getGson().fromJson(json, StudentReadDTO[].class);
        return Arrays.stream(studentReadDTO).toList();
    }

    public String loginAdmin(LoginAdmin loginAdmin) throws IOException, BadCredentialsException {
        URI uri = URI.create("http://localhost:8080/admin/login");
        String json = initializer.getGson().toJson(loginAdmin);
        CloseableHttpResponse response = initializer.doPostRequestNoToken(uri, json);
        String responseToken = verifyStatusApi(response);
        TokenDTO tokenDto = initializer.getGson().fromJson(responseToken, TokenDTO.class);
        return tokenDto.token();
    }
    public String verifyStatusApi(CloseableHttpResponse response) throws IOException, BadCredentialsException {
        if (response.getStatusLine().getStatusCode() != 200 && response.getStatusLine().getStatusCode() != 201) {
            throw new BadCredentialsException(initializer.getGson().fromJson(EntityUtils.toString(response.getEntity()), ErrorModel.class));
        }
        return EntityUtils.toString(response.getEntity());
    }

    private JsonArray getContent(String json) {
        JsonObject jsonObject = initializer.getGson().fromJson(json, JsonObject.class);
        return jsonObject.getAsJsonArray("content");
    }
}
