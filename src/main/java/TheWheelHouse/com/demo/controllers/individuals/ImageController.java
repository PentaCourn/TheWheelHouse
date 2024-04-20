package TheWheelHouse.com.demo.controllers.individuals;


import TheWheelHouse.com.demo.entities.ImageEntity;
import TheWheelHouse.com.demo.services.CarService;
import TheWheelHouse.com.demo.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;
    private final CarService car;

    @PostMapping("/add")
    public ResponseEntity<String> addImage(@RequestBody ImageEntity image) {
        imageService.addImage(image);
        return ResponseEntity.ok("Image added successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ImageEntity>> getImageById(@PathVariable Long id) {
        return ResponseEntity.ok(imageService.getImagesByCarId(id));
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<List<ImageEntity>> getImageByCarId(@PathVariable Long id) {
        return ResponseEntity.ok(imageService.getImagesByCar(car.getCarById(id)));
    }
}
