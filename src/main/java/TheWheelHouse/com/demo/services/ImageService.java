package TheWheelHouse.com.demo.services;

import TheWheelHouse.com.demo.entities.CarEntity;
import TheWheelHouse.com.demo.entities.ImageEntity;
import TheWheelHouse.com.demo.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository repository;

    public void addImage(ImageEntity image) {
        repository.save(image);
    }

    public List<ImageEntity> getImagesByCar(CarEntity car) {
        return repository.getImagesByCar(car);
    }

    public List<ImageEntity> getImagesByCarId(Long id) {
        return repository.getImagesByCarId(id);
    }
}
