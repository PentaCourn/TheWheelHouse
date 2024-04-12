package TheWheelHouse.com.demo.services;

import TheWheelHouse.com.demo.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository repository;
}
