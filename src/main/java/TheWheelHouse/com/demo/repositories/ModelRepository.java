package TheWheelHouse.com.demo.repositories;

import TheWheelHouse.com.demo.entities.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
}
