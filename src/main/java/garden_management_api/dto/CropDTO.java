package garden_management_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CropDTO {

    private Long id;
    
    @NotBlank(message = "Crop name is required")
    private String name;
    
    @NotBlank(message = "Crop variety is required")
    private String variety;
    
    @NotNull(message = "Area is required")
    @Positive(message = "Area must be greater than zero")
    private Double area;

    public CropDTO() {
    }

    public CropDTO(Long id, String name, String variety, Double area) {
        this.id = id;
        this.name = name;
        this.variety = variety;
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVariety() {
        return variety;
    }

    public Double getArea() {
        return area;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public void setArea(Double area) {
        this.area = area;
    }
}