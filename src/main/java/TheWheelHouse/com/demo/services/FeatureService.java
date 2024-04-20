package TheWheelHouse.com.demo.services;

import TheWheelHouse.com.demo.repositories.FeatureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import TheWheelHouse.com.demo.entities.FeatureEntity;

@Service
@RequiredArgsConstructor
public class FeatureService {
    private final FeatureRepository repository;

    public void addFeature(FeatureEntity feature) {
        //check if feature already exists
        if (repository.getFeatureByFeature(feature.getFeature()).isPresent()) {
            throw new IllegalArgumentException("Feature already exists");
        }
        repository.save(feature);
    }

    public void updateFeature(Long id, FeatureEntity feature) {
        FeatureEntity existingFeature = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Feature not found with id: " + id));
        existingFeature.setFeature(feature.getFeature());

        repository.save(existingFeature);
    }


    public FeatureEntity getFeatureByName(String name) {
        return repository.getFeatureByFeature(name).orElseThrow(() -> new IllegalArgumentException("Feature not found with name: " + name));
    }

    public FeatureEntity getFeatureById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Feature not found with id: " + id));
    }


}
