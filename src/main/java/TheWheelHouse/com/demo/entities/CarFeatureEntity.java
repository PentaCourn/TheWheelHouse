package TheWheelHouse.com.demo.entities;

import TheWheelHouse.com.demo.dto.CarFeatureId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Cars_Features")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(CarFeatureId.class)
public class CarFeatureEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "car_id")
    private CarEntity car;

    @Id
    @ManyToOne
    @JoinColumn(name = "feature_id")
    private FeatureEntity feature;
}
