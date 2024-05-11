package TheWheelHouse.com.demo.services;

import TheWheelHouse.com.demo.repositories.ColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ColorService {
    private final ColorRepository repository;
}
