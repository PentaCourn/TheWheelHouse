package TheWheelHouse.com.demo.repositories;

import TheWheelHouse.com.demo.dto.CarDto;
import TheWheelHouse.com.demo.dto.CarSearchCriteria;
import TheWheelHouse.com.demo.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<CarEntity, Long> {
    Optional<CarEntity> getCarByVIN(String vin);

    @Modifying
    @Query(value = "DELETE FROM Cars WHERE vin = ?1", nativeQuery = true)
    void deleteByVIN(String vin);


    @Query(value = "SELECT * FROM Cars LIMIT 6", nativeQuery = true)
    List<CarEntity> getFirstSixCars();


    @Query(value = "SELECT c.* FROM Cars c " +
            "JOIN Models m ON c.model_id = m.ID_model " +
            "JOIN Brands b ON m.brand_id = b.ID_brand " +
            "WHERE (:#{#criteria.brandName} IS NULL OR b.brand_name = :#{#criteria.brandName}) " +
            "AND (:#{#criteria.modelName} IS NULL OR m.model_name = :#{#criteria.modelName}) " +
            "AND (:#{#criteria.priceMax} IS NULL OR c.price <= :#{#criteria.priceMax}) " +
            "AND (:#{#criteria.mileageMax} IS NULL OR c.mileage <= :#{#criteria.mileageMax}) " +
            "AND (:#{#criteria.transmission} IS NULL OR c.transmission_id IN (SELECT ID_transmission FROM Transmissions WHERE type = :#{#criteria.transmission})) " +
            "AND (:#{#criteria.fuelType} IS NULL OR c.fuel_type_id IN (SELECT ID_fuel_type FROM Fuel_Types WHERE type = :#{#criteria.fuelType})) " +
            "AND (:#{#criteria.exteriorColor} IS NULL OR c.exterior_color_id IN (SELECT ID_color FROM Colors WHERE color = :#{#criteria.exteriorColor})) " +
            "AND (:#{#criteria.interiorColor} IS NULL OR c.interior_color_id IN (SELECT ID_color FROM Colors WHERE color = :#{#criteria.interiorColor})) " +
            "AND (:#{#criteria.features.isEmpty()} = true OR " +
            "    (SELECT COUNT(*) FROM Cars_Features cf " +
            "     JOIN Features f ON cf.feature_id = f.ID_feature " +
            "     WHERE cf.car_id = c.ID_car AND f.feature IN :#{#criteria.features}) = :#{#criteria.features.size()})", nativeQuery = true)
    List<CarEntity> searchCars(@Param("criteria") CarSearchCriteria criteria);
}
