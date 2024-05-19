package TheWheelHouse.com.demo.services;

import TheWheelHouse.com.demo.dto.CarDto;
import TheWheelHouse.com.demo.dto.CarFeaturesDto;
import TheWheelHouse.com.demo.dto.CarInput;
import TheWheelHouse.com.demo.dto.CarSearchCriteria;
import TheWheelHouse.com.demo.entities.*;
import TheWheelHouse.com.demo.repositories.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository repository;
    @Autowired
    private ModelMapper mapper;
    private final FeatureRepository featureRepository;
    private final CarFeatureRepository carFeatureRepository;
    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final ColorRepository colorRepository;
    private final FuelTypeRepository fuelTypeRepository;
    private final TransmissionRepository transmissionRepository;
    private final CarFeatureService carFeatureService;
    private final FeatureService featureService;

    public void addCar(CarEntity car) {
        //check if car already exists
        if (car.getVIN() == null) {
            throw new IllegalArgumentException("VIN cannot be null");
        }

        if (repository.getCarByVIN(car.getVIN()).isPresent()) {
            throw new IllegalArgumentException("Car already exists");
        }
        repository.save(car);
    }

    public void addCar(CarInput carInput){
        CarEntity car = new CarEntity();
        if (carInput.getVIN() == null) {
            throw new IllegalArgumentException("VIN cannot be null");
        }
        if (carInput.getBrand() == null) {
            throw new IllegalArgumentException("Brand cannot be null");
        }
        if (carInput.getModel() == null) {
            throw new IllegalArgumentException("Model cannot be null");
        }
        if (carInput.getTransmission() == null) {
            throw new IllegalArgumentException("Transmission cannot be null");
        }
        if (carInput.getFuelType() == null) {
            throw new IllegalArgumentException("Fuel type cannot be null");
        }
        if (carInput.getInteriorColor() == null) {
            throw new IllegalArgumentException("Interior color cannot be null");
        }
        if (carInput.getExteriorColor() == null) {
            throw new IllegalArgumentException("Exterior color cannot be null");
        }
        if (carInput.getNumberOfDoors() == null || carInput.getNumberOfDoors() <= 0){
            throw new IllegalArgumentException("Number of doors cannot be null and must be greater than 0");
        }
        if (carInput.getMileage() == null || carInput.getMileage() <= 0){
            throw new IllegalArgumentException("Mileage cannot be null and must be greater than 0");
        }
        if (carInput.getYearOfProduction() == null || carInput.getYearOfProduction() <= 0){
            throw new IllegalArgumentException("Year of production cannot be null and must be greater than 0");
        }
        if (carInput.getDescription() == null) {
            throw new IllegalArgumentException("Description cannot be null");
        }
        if (carInput.getPrice() == null || carInput.getPrice() <= 0 ){
            throw new IllegalArgumentException("Price cannot be null and must be greater than 0");
        }
        if (carInput.getPhone() == null) {
            throw new IllegalArgumentException("Phone cannot be null");
        }
        if (carInput.getImageCount() == null || carInput.getImageCount() <= 0) {
            throw new IllegalArgumentException("Image count cannot be null and must be greater than 0");
        }
        if (repository.getCarByVIN(carInput.getVIN()).isPresent()) {
            throw new IllegalArgumentException("Car already exists");
        }
        BrandEntity brand = brandRepository.getByBrandName(carInput.getBrand()).orElseThrow(() -> new IllegalArgumentException("Brand not found"));
        Long brandId = brand.getId();

        ModelEntity model = modelRepository.getModelByBrandIdAndModelName(brandId, carInput.getModel()).orElseThrow(() -> new IllegalArgumentException("Model not found"));
        car.setModelEntity(model);

        TransmissionEntity transmission = transmissionRepository.getByType(carInput.getTransmission()).orElseThrow(() -> new IllegalArgumentException("Transmission not found"));
        car.setTransmissionEntity(transmission);

        FuelTypeEntity fuelType = fuelTypeRepository.getByType(carInput.getFuelType()).orElseThrow(() -> new IllegalArgumentException("Fuel type not found"));
        car.setFuelTypeEntity(fuelType);

        ColorEntity interiorColor = colorRepository.getByColorName(carInput.getInteriorColor()).orElseThrow(() -> new IllegalArgumentException("Interior color not found"));
        car.setInteriorColorEntity(interiorColor);

        ColorEntity exteriorColor = colorRepository.getByColorName(carInput.getExteriorColor()).orElseThrow(() -> new IllegalArgumentException("Exterior color not found"));
        car.setExteriorColorEntity(exteriorColor);

        car.setNumberOfDoors(carInput.getNumberOfDoors());
        car.setMileage(carInput.getMileage());
        car.setYearOfProduction(carInput.getYearOfProduction());
        car.setDescription(carInput.getDescription());
        car.setPrice(carInput.getPrice());
        car.setPhone(carInput.getPhone());
        car.setImageCount(carInput.getImageCount());
        car.setVIN(carInput.getVIN());

        repository.save(car);
        if (carInput.getFeatures() != null && !carInput.getFeatures().isEmpty()) {
            CarFeaturesDto carFeaturesDto = new CarFeaturesDto();
            carFeaturesDto.setCarEntity(car);
            carFeaturesDto.setFeatures(carInput.getFeatures());
            carFeatureService.addCarFeatureList(carFeaturesDto);
        }
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

    public CarDto getCarDtoByVIN(String vin) {
        CarEntity car = repository.getCarByVIN(vin).orElseThrow(() -> new IllegalArgumentException("Car not found with vin: " + vin));
        CarDto carDto = mapToDto(car);
        List<String> images = new ArrayList<>();
        for (int i = 1; i <= carDto.getImageCount(); i++) {
            images.add("http://localhost:8081/" + carDto.getVIN() + "/" + i + ".png");
        }
        List<Long> features = carFeatureService.getFeaturesByCarId(car.getId());
        List<String> featureNames = new ArrayList<>();
        for (Long feature : features) {
            featureNames.add(featureService.getFeatureById(feature));
        }
        carDto.setImages(images);
        carDto.setFeatures(featureNames);
        return carDto;

    }

    public CarEntity getCarById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Car not found with id: " + id));
    }

    public CarDto getFirstCar() {
        CarDto carDto;
        CarEntity car = repository.findById(1L).orElse(null);

        carDto = mapToDto(repository.findById(1L).orElseThrow(() -> new IllegalArgumentException("Car not found with id: 1")));

        List<String> images = new ArrayList<>();

        for (int i = 1; i <= carDto.getImageCount(); i++) {
            images.add("http://localhost:8081/" + carDto.getVIN() + "/" + i + ".png");
        }
        carDto.setImages(images);
        return carDto;
    }

    public List<CarDto> getExampleCar() {
       //returns the first 6 cars
        List<CarDto> carDtos = new ArrayList<>();
        List<CarEntity> cars = repository.getFirstSixCars();

        return getCarDtos(carDtos, cars);

    }

    public List<CarDto> getSearchedCars(CarSearchCriteria searchCriteria){
        List<CarDto> carDtos = new ArrayList<>();
        List<CarEntity> cars = repository.searchCars(searchCriteria);

        return getCarDtos(carDtos, cars);
    }



    private CarEntity mapToEntity(CarDto carDto) {
        return mapper.map(carDto, CarEntity.class);
    }

    private CarDto mapToDto(CarEntity car) {
        return mapper.map(car, CarDto.class);
    }



    private List<CarDto> getCarDtos(List<CarDto> carDtos, List<CarEntity> cars) {
        for (CarEntity car : cars) {
            CarDto carDto = mapToDto(car);
            List<String> images = new ArrayList<>();
            for (int i = 1; i <= carDto.getImageCount(); i++) {
                images.add("http://localhost:8081/" + carDto.getVIN() + "/" + i + ".png");
            }
            List<Long> features = carFeatureService.getFeaturesByCarId(car.getId());
            List<String> featureNames = new ArrayList<>();
            for (Long feature : features) {
                featureNames.add(featureService.getFeatureById(feature));
            }
            carDto.setFeatures(featureNames);
            carDto.setImages(images);
            carDtos.add(carDto);
        }
        return carDtos;
    }
}
