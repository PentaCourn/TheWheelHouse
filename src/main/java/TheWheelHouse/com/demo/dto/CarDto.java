package TheWheelHouse.com.demo.dto;


import TheWheelHouse.com.demo.entities.ColorEntity;
import TheWheelHouse.com.demo.entities.FuelTypeEntity;
import TheWheelHouse.com.demo.entities.ModelEntity;
import TheWheelHouse.com.demo.entities.TransmissionEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CarDto {
    private Long id;
    @JsonProperty("VIN")
    private String VIN;
    private ModelEntity modelEntity;
    private TransmissionEntity transmissionEntity;
    private FuelTypeEntity fuelTypeEntity;
    private ColorEntity interiorColorEntity;
    private ColorEntity exteriorColorEntity;
    private Integer numberOfDoors;
    private Integer mileage;
    private Integer yearOfProduction;
    private String description;
    private Double price;
    private String phone;
    private Integer imageCount;
    private List<String> images;
    private List<String> features;
}
