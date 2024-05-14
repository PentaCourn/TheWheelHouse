package TheWheelHouse.com.demo.repositories;

import TheWheelHouse.com.demo.entities.ColorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ColorRepository extends JpaRepository<ColorEntity, Long> {
    //get all
    List<ColorEntity> findAll();

    @Query(value = "SELECT * FROM Colors WHERE color = ?1", nativeQuery = true)
    Optional<ColorEntity> getByColorName(String interiorColor);
}
