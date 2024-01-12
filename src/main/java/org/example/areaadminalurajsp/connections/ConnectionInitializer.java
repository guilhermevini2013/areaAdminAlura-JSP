package org.example.areaadminalurajsp.connections;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.http.HttpResponse;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ConnectionInitializer {
    private CloseableHttpClient httpClient = HttpClients.createDefault();
    private HttpGet httpGet;
    private HttpPost httpPost;
    private HttpResponse httpResponse;
    private HttpDelete httpDelete;
    private HttpPut httpPut;

    public CloseableHttpResponse doGetRequest(URI uri) throws IOException {
        httpGet = new HttpGet(uri);
        return httpClient.execute(httpGet);
    }
    public CloseableHttpResponse doPostRequest(URI uri, String json) throws IOException {
        httpPost = new HttpPost(uri);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-type", "application/json");
        return httpClient.execute(httpPost);
    }
    public CloseableHttpResponse doDeleteRequest(URI uri) throws IOException {
        httpDelete = new HttpDelete(uri);
        return httpClient.execute(httpDelete);
    }
    public CloseableHttpResponse doPutRequest(URI uri, String json) throws IOException {
        httpPut = new HttpPut(uri);
        StringEntity entity = new StringEntity(json);
        httpPut.setEntity(entity);
        httpPut.setHeader("Content-type", "application/json");
        return httpClient.execute(httpPut);
    }
}
