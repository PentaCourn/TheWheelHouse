package TheWheelHouse.com.demo.controllers.individuals;

import TheWheelHouse.com.demo.entities.CarEntity;
import TheWheelHouse.com.demo.entities.CarFeatureEntity;
import TheWheelHouse.com.demo.entities.FeatureEntity;
import TheWheelHouse.com.demo.services.CarFeatureService;
import TheWheelHouse.com.demo.services.CarService;
import TheWheelHouse.com.demo.services.FeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car-features")
@RequiredArgsConstructor
public class CarFeatureController {
    private final CarFeatureService carFeatureService;
    private final CarService carService;
    private final FeatureService featureService;

    @PostMapping("/add")
    public ResponseEntity<String> addCarFeature(@RequestBody CarFeatureEntity carFeature) {
        carFeatureService.addCarFeature(carFeature);
        return ResponseEntity.ok("CarFeature added successfully");
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<CarFeatureEntity> getCarFeatureByCarId(@PathVariable Long id) {
        return ResponseEntity.ok(carFeatureService.getCarFeatureByCarId(carService.getCarById(id)));
    }

    @GetMapping("/feature/{id}")
    public ResponseEntity<CarFeatureEntity> getCarFeatureByFeatureId(@PathVariable Long id) {
        return ResponseEntity.ok(carFeatureService.getCarFeatureByFeatureId(featureService.getFeatureById(id)));
    }
}
