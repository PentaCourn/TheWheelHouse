package TheWheelHouse.com.demo.services;

import TheWheelHouse.com.demo.entities.FuelTypeEntity;
import TheWheelHouse.com.demo.repositories.FuelTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuelTypeService {
    private final FuelTypeRepository repository;

    public List<FuelTypeEntity> getAllFuelTypes() {
        return repository.findAll();
    }
}
