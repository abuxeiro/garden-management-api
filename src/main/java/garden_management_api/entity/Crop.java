package garden_management_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "crops")
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String variety;

    private Double area;

    public Crop() {
    }

    public Crop(String name, String variety, Double area) {
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