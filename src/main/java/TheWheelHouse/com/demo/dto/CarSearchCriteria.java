package TheWheelHouse.com.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CarSearchCriteria {
    private String brandName;
    private String modelName;
    private Double priceMax;
    private Double mileageMax;
    private String transmission;
    private String fuelType;
    private String exteriorColor;
    private String interiorColor;
    private List<String> features;
}
