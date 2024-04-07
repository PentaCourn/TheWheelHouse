package TheWheelHouse.com.demo.repositories;

import TheWheelHouse.com.demo.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity, Long> {
}