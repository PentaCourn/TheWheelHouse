package TheWheelHouse.com.demo.repositories;

import TheWheelHouse.com.demo.entities.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<BrandEntity, Long> {
    @Modifying
    @Query(value = "DELETE FROM Brands WHERE brand_name = ?1", nativeQuery = true)
    void deleteByBrandName(String name);

    Optional<BrandEntity> getByBrandName(String name);
}
