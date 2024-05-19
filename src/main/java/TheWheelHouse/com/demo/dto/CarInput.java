package TheWheelHouse.com.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CarInput {
    @JsonProperty("VIN")
    private String VIN;
    private String brand;
    private String model;
    private String transmission;
    private String fuelType;
    private String interiorColor;
    private String exteriorColor;
    private Integer numberOfDoors;
    private Integer mileage;
    private Integer yearOfProduction;
    private String description;
    private Double price;
    private String phone;
    private Integer imageCount;
    private List<Long> features;
}
