package TheWheelHouse.com.demo.services;

import TheWheelHouse.com.demo.repositories.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository repository;
}
