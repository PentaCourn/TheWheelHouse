package TheWheelHouse.com.demo.services;

import TheWheelHouse.com.demo.entities.ColorEntity;
import TheWheelHouse.com.demo.repositories.ColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ColorService {
    private final ColorRepository repository;

    public List<ColorEntity> getAllColors() {

        return repository.findAll();

    }
}
