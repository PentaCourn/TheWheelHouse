package TheWheelHouse.com.demo.controllers.individuals;

import TheWheelHouse.com.demo.entities.ModelEntity;
import TheWheelHouse.com.demo.services.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/models")
@RequiredArgsConstructor
public class ModelController {
    private final ModelService modelService;

    @PostMapping("/add")
    public ResponseEntity<String> addModel(@RequestBody ModelEntity model) {
        modelService.addModel(model);
        return ResponseEntity.ok("Model added successfully");
    }

    @PutMapping("/{name}/update")
    public ResponseEntity<String> updateModel(@PathVariable String name, @RequestBody ModelEntity model) {
        modelService.updateModel(name, model);
        return ResponseEntity.ok("Model updated successfully");
    }

    @DeleteMapping("/{name}/delete")
    public ResponseEntity<String> deleteModel(@PathVariable String name) {
        modelService.deleteModel(name);
        return ResponseEntity.ok("Model deleted successfully");
    }

    @GetMapping("/{name}")
    public ResponseEntity<ModelEntity> getModelByName(@PathVariable String name) {
        return ResponseEntity.ok(modelService.getModelByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelEntity> getModelById(@PathVariable Long id) {
        return ResponseEntity.ok(modelService.getModelById(id));
    }
}
