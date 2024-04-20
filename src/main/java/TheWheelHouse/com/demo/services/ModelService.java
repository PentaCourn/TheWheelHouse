package TheWheelHouse.com.demo.services;

import TheWheelHouse.com.demo.entities.ModelEntity;
import TheWheelHouse.com.demo.repositories.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelService {
    private final ModelRepository repository;

    public void addModel(ModelEntity model) {
        //check if model already exists
        if (repository.getByModelName(model.getModelName()).isPresent()) {
            throw new IllegalArgumentException("Model already exists");
        }
        repository.save(model);
    }

    public void updateModel(String name, ModelEntity model) {
        ModelEntity existingModel = repository.getByModelName(name).orElseThrow(() -> new IllegalArgumentException("Model not found with name: " + name));
        existingModel.setBrandEntity(model.getBrandEntity());
        repository.save(existingModel);
    }

    public void deleteModel(String name) {
        repository.deleteByModelName(name);
    }

    public ModelEntity getModelByName(String name) {
        return repository.getByModelName(name).orElseThrow(() -> new IllegalArgumentException("Model not found with name: " + name));
    }

    public ModelEntity getModelById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Model not found with id: " + id));
    }
}
