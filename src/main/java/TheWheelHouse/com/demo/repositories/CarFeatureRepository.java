package TheWheelHouse.com.demo.repositories;

import TheWheelHouse.com.demo.entities.CarEntity;
import TheWheelHouse.com.demo.entities.CarFeatureEntity;
import TheWheelHouse.com.demo.entities.FeatureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarFeatureRepository extends JpaRepository<CarFeatureEntity, Long> {
    @Query(value = "SELECT * FROM Cars_Features WHERE car_id = ?1", nativeQuery = true)
    List<CarFeatureEntity> getCarFeatureByCar(Long id);

    @Query(value = "SELECT * FROM Cars_Features WHERE feature_id = ?1", nativeQuery = true)
    List<CarFeatureEntity> getCarFeatureByFeature(Long id);


    @Query(value = "SELECT feature_id FROM Cars_Features WHERE car_id = ?1", nativeQuery = true)
    List<Long> getFeaturesByCarId(Long id);
}
