package TheWheelHouse.com.demo.services;

import TheWheelHouse.com.demo.dto.CarFeaturesDto;
import TheWheelHouse.com.demo.entities.CarEntity;
import TheWheelHouse.com.demo.entities.CarFeatureEntity;
import TheWheelHouse.com.demo.entities.FeatureEntity;
import TheWheelHouse.com.demo.repositories.CarFeatureRepository;
import TheWheelHouse.com.demo.repositories.FeatureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarFeatureService {
    private final CarFeatureRepository repository;
    private final FeatureRepository featureRepository;

    public boolean addCarFeature(CarFeatureEntity carFeature) {
        List<CarFeatureEntity> carFeaturesByCar = repository.getCarFeatureByCar(carFeature.getCar().getId());
        List<CarFeatureEntity> carFeaturesByFeature = repository.getCarFeatureByFeature(carFeature.getFeature().getId());

        if (!carFeaturesByCar.isEmpty() && !carFeaturesByFeature.isEmpty()) {
            return false;
        }
        repository.save(carFeature);
        return true;
    }


    public List<Long> getFeaturesByCarId(Long id) {
        return repository.getFeaturesByCarId(id);
    }


    public void addCarFeatureList(CarFeaturesDto carFeaturesDto) {
        CarEntity car = carFeaturesDto.getCarEntity();
        List<Long> features = carFeaturesDto.getFeatures();
        FeatureEntity feature;

        for (Long featureId : features) {
            CarFeatureEntity carFeature = new CarFeatureEntity();
            carFeature.setCar(car);
            feature = featureRepository.getById(featureId);
            carFeature.setFeature(feature);
            repository.save(carFeature);
        }


    }
}
