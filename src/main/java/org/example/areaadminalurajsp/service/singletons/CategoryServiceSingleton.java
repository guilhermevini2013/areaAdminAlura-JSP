package org.example.areaadminalurajsp.service.singletons;

import com.google.gson.Gson;
import org.apache.http.impl.client.HttpClients;
import org.example.areaadminalurajsp.connections.ConnectionInitializer;
import org.example.areaadminalurajsp.connections.api.content.CategoryConnection;
import org.example.areaadminalurajsp.service.content.CategoryService;

public class CategoryServiceSingleton {
    private static CategoryService categoryService;

    private CategoryServiceSingleton() {
        Gson gson = new Gson();
        ConnectionInitializer initializer = new ConnectionInitializer(HttpClients.createDefault(), gson);
        CategoryConnection categoryConnection = new CategoryConnection(initializer);
        categoryService = new CategoryService(categoryConnection);
    }

    public static CategoryService getInstance() {
        if (categoryService == null) {
            new CategoryServiceSingleton();
        }
        return categoryService;
    }
}
