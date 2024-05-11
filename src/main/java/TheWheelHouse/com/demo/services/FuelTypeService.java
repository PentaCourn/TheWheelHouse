package TheWheelHouse.com.demo.services;

import TheWheelHouse.com.demo.repositories.FuelTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FuelTypeService {
    private final FuelTypeRepository repository;
}
