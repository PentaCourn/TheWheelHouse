package TheWheelHouse.com.demo.services;

import TheWheelHouse.com.demo.repositories.FeatureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeatureService {
    private final FeatureRepository repository;
}
