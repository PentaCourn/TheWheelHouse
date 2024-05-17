package TheWheelHouse.com.demo.repositories;

import TheWheelHouse.com.demo.entities.FeatureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface FeatureRepository extends JpaRepository<FeatureEntity, Long> {

    @Query(value = "SELECT * FROM Features WHERE feature = ?1", nativeQuery = true)
    Optional<FeatureEntity> getFeatureByFeature(String name);
    @Query(value = "SELECT f.feature FROM Features f " +
            "JOIN Cars_Features cf ON f.ID_feature = cf.feature_id " +
            "WHERE cf.car_id = :id", nativeQuery = true)
    List<String> getFeaturesByCarId(@Param("id") Long id);

    @Query(value = "SELECT feature FROM Features WHERE ID_feature = ?1", nativeQuery = true)
    Optional<String>  getFeatureById(Long feature);

    @Query(value = "SELECT * FROM Features WHERE ID_feature = ?1", nativeQuery = true)
    FeatureEntity getById(Long featureId);
}
