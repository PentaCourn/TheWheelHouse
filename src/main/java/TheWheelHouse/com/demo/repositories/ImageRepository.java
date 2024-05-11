package TheWheelHouse.com.demo.repositories;

import TheWheelHouse.com.demo.entities.CarEntity;
import TheWheelHouse.com.demo.entities.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
    List<ImageEntity> getImagesByCar(CarEntity car);

    List<ImageEntity> getImagesByCarId(Long id);

}
