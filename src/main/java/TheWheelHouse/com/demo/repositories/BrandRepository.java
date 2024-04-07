package TheWheelHouse.com.demo.repositories;

import TheWheelHouse.com.demo.entities.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<BrandEntity, Long> {
}
