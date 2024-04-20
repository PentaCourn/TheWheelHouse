package TheWheelHouse.com.demo.services;

import TheWheelHouse.com.demo.entities.Test;
import TheWheelHouse.com.demo.repositories.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    public void addTest(Test test) {
        testRepository.save(test);
    }

    public Test getTestById(Long id) {
        return testRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Test not found with id: " + id));
    }
}
