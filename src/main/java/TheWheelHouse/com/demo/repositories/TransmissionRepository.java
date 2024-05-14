package TheWheelHouse.com.demo.repositories;

import TheWheelHouse.com.demo.entities.TransmissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TransmissionRepository extends JpaRepository<TransmissionEntity, Long>{
    @Query(value = "SELECT * FROM Transmissions WHERE type = ?1", nativeQuery = true)
    Optional<TransmissionEntity> getByType(String type);
}