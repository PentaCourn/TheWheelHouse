package TheWheelHouse.com.demo.repositories;

import TheWheelHouse.com.demo.entities.CarEntity;
import TheWheelHouse.com.demo.entities.CarFeatureEntity;
import TheWheelHouse.com.demo.entities.FeatureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarFeatureRepository extends JpaRepository<CarFeatureEntity, Long> {
    Optional<CarFeatureEntity> getCarFeatureByCar(CarEntity car);
    Optional<CarFeatureEntity> getCarFeatureByFeature(FeatureEntity feature);
}
