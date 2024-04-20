package TheWheelHouse.com.demo.repositories;

import TheWheelHouse.com.demo.entities.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
    Optional<ModelEntity> getByModelName(String name);

    @Modifying
    @Query(value = "DELETE FROM Models WHERE model_name = ?1", nativeQuery = true)
    void deleteByModelName(String name);
}
