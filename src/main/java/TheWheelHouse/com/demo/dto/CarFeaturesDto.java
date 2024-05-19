package TheWheelHouse.com.demo.dto;

import TheWheelHouse.com.demo.entities.CarEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CarFeaturesDto {
    private CarEntity carEntity;
    private List<Long> features;
}
