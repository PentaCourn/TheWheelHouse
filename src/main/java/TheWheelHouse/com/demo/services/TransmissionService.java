package TheWheelHouse.com.demo.services;

import TheWheelHouse.com.demo.repositories.TransmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransmissionService {
    private final TransmissionRepository repository;
}
