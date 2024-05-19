package TheWheelHouse.com.demo.services;

import TheWheelHouse.com.demo.entities.BrandEntity;
import TheWheelHouse.com.demo.repositories.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository repository;

    public void addBrand(BrandEntity brand) {
        //check if brand already exists
        if (repository.getByBrandName(brand.getBrandName()).isPresent()) {
            throw new IllegalArgumentException("Brand already exists");
        }
        repository.save(brand);
    }

    public void updateBrand(Long id, BrandEntity brand) {
        BrandEntity existingBrand = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Brand not found with id: " + id));
        existingBrand.setBrandName(brand.getBrandName());
        repository.save(existingBrand);
    }

    public BrandEntity getBrandById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Brand not found with id: " + id));
    }

    public BrandEntity getBrandByName(String name) {
        return repository.getByBrandName(name).orElseThrow(() -> new IllegalArgumentException("Brand not found with name: " + name));
    }

    public List<BrandEntity> getAllBrands() {
        return repository.findAll();
    }

    public void addBrands(List<BrandEntity> brands) {
        for (BrandEntity brand : brands) {
            addBrand(brand);
        }
    }
}
