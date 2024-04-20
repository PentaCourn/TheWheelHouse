package TheWheelHouse.com.demo.controllers.individuals;

import TheWheelHouse.com.demo.entities.BrandEntity;
import TheWheelHouse.com.demo.services.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;


    @GetMapping("/")
    public ResponseEntity<List<BrandEntity>> getBrands() {
        return ResponseEntity.ok(brandService.getAllBrands());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandEntity> getBrandById(@PathVariable Long id) {
        return ResponseEntity.ok(brandService.getBrandById(id));
    }

    @PostMapping("/")
    public ResponseEntity<String> addBrand(@RequestBody BrandEntity brand) {
        brandService.addBrand(brand);
        return ResponseEntity.ok("Brand added successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBrand(@PathVariable Long id, @RequestBody BrandEntity brand) {
        brandService.updateBrand(id, brand);
        return ResponseEntity.ok("Brand updated successfully");
    }

    //няма да слагам delete щото нямаме автентикация
}
