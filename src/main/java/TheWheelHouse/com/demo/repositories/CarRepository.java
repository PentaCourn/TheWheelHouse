package TheWheelHouse.com.demo.repositories;

import TheWheelHouse.com.demo.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CarRepository extends JpaRepository<CarEntity, Long> {
    Optional<CarEntity> getCarByVIN(String vin);

    @Modifying
    @Query(value = "DELETE FROM Cars WHERE vin = ?1", nativeQuery = true)
    void deleteByVIN(String vin);
}
