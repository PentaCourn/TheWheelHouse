package TheWheelHouse.com.demo.controllers.individuals;

import TheWheelHouse.com.demo.dto.CarDto;
import TheWheelHouse.com.demo.dto.CarInput;
import TheWheelHouse.com.demo.dto.CarSearchCriteria;
import TheWheelHouse.com.demo.entities.CarEntity;
import TheWheelHouse.com.demo.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @PostMapping("/add")
    public ResponseEntity<String> addCar(@RequestBody CarEntity car) {
        carService.addCar(car);
        return ResponseEntity.ok("Car added successfully");
    }

    @PostMapping("/add/carInput")
    public ResponseEntity<String> addCar(@RequestBody CarInput input) {
        carService.addCar(input);
        return ResponseEntity.ok("Car added successfully");
    }

    @PutMapping("/{vin}/update")
    public ResponseEntity<String> updateCar(@PathVariable String vin, @RequestBody CarEntity car) {
        carService.updateCar(vin, car);
        return ResponseEntity.ok("Car updated successfully");
    }

    @DeleteMapping("/{vin}/delete")
    public ResponseEntity<String> deleteCar(@PathVariable String vin) {
        carService.deleteCar(vin);
        return ResponseEntity.ok("Car deleted successfully");
    }



    @GetMapping("/id/{id}")
    public ResponseEntity<CarEntity> getCarById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }

    //get endpoint that returns the first car in the database
    @GetMapping("/first")
    public ResponseEntity<CarDto> getFirstCar() {
        return ResponseEntity.ok(carService.getFirstCar());
    }

    @GetMapping("/example")
    public ResponseEntity<List<CarDto>> getExampleCar() {
        return ResponseEntity.ok(carService.getExampleCar());
    }

    @PostMapping("/search")
    public ResponseEntity<List<CarDto>> searchCars(@RequestBody CarSearchCriteria criteria) {
        return ResponseEntity.ok(carService.getSearchedCars(criteria));
    }

    @GetMapping("/{vin}")
    public ResponseEntity<CarDto> getCarDtoByVIN(@PathVariable String vin) {
        return ResponseEntity.ok(carService.getCarDtoByVIN(vin));
    }
}
