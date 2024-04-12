package TheWheelHouse.com.demo.services;

import TheWheelHouse.com.demo.repositories.CarFeatureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarFeatureService {
    private final CarFeatureRepository repository;
}
