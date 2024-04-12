package TheWheelHouse.com.demo.services;

import TheWheelHouse.com.demo.repositories.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelService {
    private final ModelRepository repository;
}
