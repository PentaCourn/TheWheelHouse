package TheWheelHouse.com.demo.controllers.individuals;

import TheWheelHouse.com.demo.entities.FeatureEntity;
import TheWheelHouse.com.demo.services.FeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/features")
@RequiredArgsConstructor
public class FeatureController {
    private final FeatureService featureService;

    @PostMapping("/add")
    public ResponseEntity<String> addFeature(@RequestBody FeatureEntity feature) {
        featureService.addFeature(feature);
        return ResponseEntity.ok("Feature added successfully");
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<String> updateFeature(@PathVariable Long id, @RequestBody FeatureEntity feature) {
        featureService.updateFeature(id, feature);
        return ResponseEntity.ok("Feature updated successfully");
    }


}
