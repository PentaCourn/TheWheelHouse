package TheWheelHouse.com.demo.controllers.individuals;

import TheWheelHouse.com.demo.entities.CarEntity;
import TheWheelHouse.com.demo.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{vin}")
    public ResponseEntity<CarEntity> getCarByVIN(@PathVariable String vin) {
        return ResponseEntity.ok(carService.getCarByVIN(vin));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarEntity> getCarById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }
}
