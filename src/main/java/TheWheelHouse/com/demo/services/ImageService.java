package TheWheelHouse.com.demo.services;

import TheWheelHouse.com.demo.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository repository;
}
