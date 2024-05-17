package TheWheelHouse.com.demo.controllers.individuals;

import TheWheelHouse.com.demo.entities.FeatureEntity;
import TheWheelHouse.com.demo.services.FeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/addList")
    public ResponseEntity<String> addFeatures(@RequestBody List<FeatureEntity> features) {
        featureService.addFeatures(features);
        return ResponseEntity.ok("Features added successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getFeatureById(@PathVariable Long id) {
        return ResponseEntity.ok(featureService.getFeatureById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<FeatureEntity>> getFeatures() {
        return ResponseEntity.ok(featureService.getAllFeatures());
    }

}
