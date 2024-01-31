package org.example.areaadminalurajsp.connections;


import com.google.gson.Gson;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URI;


public class ConnectionInitializer {
    private CloseableHttpClient httpClient;
    private HttpGet httpGet;
    private HttpPost httpPost;
    private HttpDelete httpDelete;
    private HttpPut httpPut;
    private Gson gson;

    public ConnectionInitializer(CloseableHttpClient httpClient,Gson gson) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public CloseableHttpResponse doGetRequest(URI uri, String token) throws IOException {
        httpGet = new HttpGet(uri);
        httpGet.setHeader("Authorization", "Bearer " + token);
        return httpClient.execute(httpGet);
    }

    public CloseableHttpResponse doPostRequest(URI uri, String token, String json) throws IOException {
        httpPost = new HttpPost(uri);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setHeader("Authorization", "Bearer " + token);
        return httpClient.execute(httpPost);
    }
    public CloseableHttpResponse doPostRequestNoToken(URI uri, String json) throws IOException {
        httpPost = new HttpPost(uri);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-type", "application/json");
        return httpClient.execute(httpPost);
    }
    public CloseableHttpResponse doPostRequest(URI uri, String token) throws IOException {
        httpPost = new HttpPost(uri);
        httpPost.setHeader("Authorization", "Bearer " + token);
        return httpClient.execute(httpPost);
    }

    public CloseableHttpResponse doDeleteRequest(URI uri,String token) throws IOException {
        httpDelete = new HttpDelete(uri);
        httpDelete.setHeader("Authorization", "Bearer " + token);
        return httpClient.execute(httpDelete);
    }

    public CloseableHttpResponse doPutRequest(URI uri,String token, String json) throws IOException {
        httpPut = new HttpPut(uri);
        StringEntity entity = new StringEntity(json);
        httpPut.setEntity(entity);
        httpPut.setHeader("Authorization", "Bearer " + token);
        httpPut.setHeader("Content-type", "application/json");
        return httpClient.execute(httpPut);
    }

    public Gson getGson() {
        return gson;
    }
}
