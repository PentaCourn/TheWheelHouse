package TheWheelHouse.com.demo.repositories;

import TheWheelHouse.com.demo.entities.ColorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<ColorEntity, Long> {
}
