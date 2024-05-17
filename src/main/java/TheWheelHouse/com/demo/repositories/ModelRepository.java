package TheWheelHouse.com.demo.repositories;

import TheWheelHouse.com.demo.entities.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
    Optional<ModelEntity> getByModelName(String name);

    @Modifying
    @Query(value = "DELETE FROM Models WHERE model_name = ?1", nativeQuery = true)
    void deleteByModelName(String name);

    @Query(value = "SELECT * FROM Models WHERE brand_id = ?1", nativeQuery = true)
    List<ModelEntity> getAllByBrandEntity_Id(Long id);

    @Query(value = "SELECT * FROM Models WHERE brand_id = ?1 AND model_name = ?2", nativeQuery = true)
    Optional<ModelEntity> getModelByBrandIdAndModelName(Long brandId, String modelName);
}
