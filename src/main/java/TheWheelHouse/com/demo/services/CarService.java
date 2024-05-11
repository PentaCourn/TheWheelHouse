package TheWheelHouse.com.demo.services;

import TheWheelHouse.com.demo.entities.CarEntity;
import TheWheelHouse.com.demo.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository repository;

    public void addCar(CarEntity car) {
        //check if car already exists
        if (repository.getCarByVIN(car.getVIN()).isPresent()) {
            throw new IllegalArgumentException("Car already exists");
        }
        repository.save(car);
    }

    public void updateCar(String vin, CarEntity car) {
        CarEntity existingCar = repository.getCarByVIN(vin).orElseThrow(() -> new IllegalArgumentException("Car not found with vin: " + vin));
        existingCar.setModelEntity(car.getModelEntity());
        existingCar.setTransmissionEntity(car.getTransmissionEntity());
        existingCar.setFuelTypeEntity(car.getFuelTypeEntity());
        existingCar.setInteriorColorEntity(car.getInteriorColorEntity());
        existingCar.setExteriorColorEntity(car.getExteriorColorEntity());
        existingCar.setNumberOfDoors(car.getNumberOfDoors());
        existingCar.setMileage(car.getMileage());
        existingCar.setYearOfProduction(car.getYearOfProduction());
        existingCar.setDescription(car.getDescription());
        existingCar.setPrice(car.getPrice());

        repository.save(existingCar);
    }

    public void deleteCar(String vin) {
        repository.deleteByVIN(vin);
    }

    public CarEntity getCarByVIN(String vin) {
        return repository.getCarByVIN(vin).orElseThrow(() -> new IllegalArgumentException("Car not found with vin: " + vin));
    }

    public CarEntity getCarById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Car not found with id: " + id));
    }
}
