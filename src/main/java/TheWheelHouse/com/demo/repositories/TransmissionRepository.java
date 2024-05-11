package TheWheelHouse.com.demo.repositories;

import TheWheelHouse.com.demo.entities.TransmissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransmissionRepository extends JpaRepository<TransmissionEntity, Long>{
}