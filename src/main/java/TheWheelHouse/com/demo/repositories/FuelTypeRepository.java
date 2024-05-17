package TheWheelHouse.com.demo.repositories;

import TheWheelHouse.com.demo.entities.FuelTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FuelTypeRepository extends JpaRepository<FuelTypeEntity, Long> {
    @Query(value = "SELECT * FROM Fuel_Types WHERE type = ?1", nativeQuery = true)
    Optional<FuelTypeEntity> getByType(String fuelType);
}
