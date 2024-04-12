package TheWheelHouse.com.demo.repositories;

import TheWheelHouse.com.demo.entities.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
}
