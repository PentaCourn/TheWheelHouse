package TheWheelHouse.com.demo.repositories;

import TheWheelHouse.com.demo.entities.FeatureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;

public interface FeatureRepository extends JpaRepository<FeatureEntity, Long> {

    @Query(value = "SELECT * FROM Features WHERE feature_name = ?1", nativeQuery = true)
    Optional<FeatureEntity> getFeatureByFeature(String name);

}
