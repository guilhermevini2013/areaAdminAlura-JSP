package org.example.areaadminalurajsp.service.content;

import org.example.areaadminalurajsp.connections.api.content.CategoryConnection;
import org.example.areaadminalurajsp.dtos.read.CategoryReadDTO;

import java.io.IOException;

public class CategoryService {
    private final CategoryConnection connection;

    public CategoryService(CategoryConnection connection) {
        this.connection = connection;
    }
    public CategoryReadDTO[] getAllCategories(String token) throws IOException {
        return connection.getAllCategories(token);
    }
}
