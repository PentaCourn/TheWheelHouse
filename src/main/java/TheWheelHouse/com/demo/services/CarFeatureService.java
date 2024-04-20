package TheWheelHouse.com.demo.services;

import TheWheelHouse.com.demo.entities.CarEntity;
import TheWheelHouse.com.demo.entities.CarFeatureEntity;
import TheWheelHouse.com.demo.entities.FeatureEntity;
import TheWheelHouse.com.demo.repositories.CarFeatureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarFeatureService {
    private final CarFeatureRepository repository;

    public void addCarFeature(CarFeatureEntity carFeature) {
        repository.save(carFeature);
    }

    public CarFeatureEntity getCarFeatureByCarId(CarEntity car) {
        return repository.getCarFeatureByCar(car).orElseThrow(() -> new IllegalArgumentException("CarFeature not found with id: " + car.getId()));
    }

    public CarFeatureEntity getCarFeatureByFeatureId(FeatureEntity feature) {
        return repository.getCarFeatureByFeature(feature).orElseThrow(() -> new IllegalArgumentException("CarFeature not found with id: " + feature.getId()));
    }
}
