package org.example.areaadminalurajsp.dtos.read;

public class CategoryReadDTO {
    private Long id;
    private String nameCategory;

    public CategoryReadDTO(Long id, String nameCategory) {
        this.id = id;
        this.nameCategory = nameCategory;
    }
    public CategoryReadDTO(){

    }

    public Long getId() {
        return id;
    }
    public String getNameCategory() {
        return nameCategory;
    }
}
