package org.example.areaadminalurajsp;

import org.example.areaadminalurajsp.dtos.read.CategoryReadDTO;
import org.example.areaadminalurajsp.service.content.CategoryService;
import org.example.areaadminalurajsp.service.singletons.CategoryServiceSingleton;

import java.io.IOException;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws IOException {
        CategoryService adminService = CategoryServiceSingleton.getInstance();
        CategoryReadDTO[] allCategories = adminService.getAllCategories("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImFkbWluQGFkbWluIiwiZXhwIjoxNzA3NDgxNDg4fQ.KUbm4t1vCM5cfEtseGgFpXo8YaqkpgCgVdiZYPoN1xo");
        Arrays.stream(allCategories).toList().forEach(x-> System.out.println(x.getNameCategory()));
    }
}
