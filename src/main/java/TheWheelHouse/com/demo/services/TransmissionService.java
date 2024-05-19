package TheWheelHouse.com.demo.services;

import TheWheelHouse.com.demo.entities.TransmissionEntity;
import TheWheelHouse.com.demo.repositories.TransmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransmissionService {
    private final TransmissionRepository repository;

    public List<TransmissionEntity> getAllTransmissions() {
        return repository.findAll();
    }
}
