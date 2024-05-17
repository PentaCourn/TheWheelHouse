package TheWheelHouse.com.demo.controllers.individuals;

import TheWheelHouse.com.demo.entities.ModelEntity;
import TheWheelHouse.com.demo.services.BrandService;
import TheWheelHouse.com.demo.services.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/models")
@RequiredArgsConstructor
public class ModelController {
    private final ModelService modelService;
    private final BrandService brandService;

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

    @GetMapping("/all/{brandName}")
    public ResponseEntity<List<ModelEntity>> getAllModelsByBrandId(@PathVariable String brandName) {
        Long id = brandService.getBrandByName(brandName).getId();
        return ResponseEntity.ok(modelService.getAllModelsByBrandId(id));
    }

    @PostMapping("/addList")
    public ResponseEntity<String> addModelList(@RequestBody List<ModelEntity> modelList) {
        modelService.addModelList(modelList);
        return ResponseEntity.ok("Models added successfully");
    }
}
