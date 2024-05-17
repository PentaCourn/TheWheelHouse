package TheWheelHouse.com.demo.controllers.individuals;

import TheWheelHouse.com.demo.entities.FuelTypeEntity;
import TheWheelHouse.com.demo.services.FuelTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fuels")
@RequiredArgsConstructor
public class FuelTypeController {
    private final FuelTypeService fuelTypeService;

    @GetMapping("/")
    public ResponseEntity<List<FuelTypeEntity>> getAllFuelTypes() {
        return ResponseEntity.ok(fuelTypeService.getAllFuelTypes());
    }
}
