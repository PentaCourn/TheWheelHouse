package TheWheelHouse.com.demo.services;

import TheWheelHouse.com.demo.entities.Test;
import TheWheelHouse.com.demo.repositories.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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


    public void addTestWithImage(Test test, MultipartFile image) throws IOException {
        test.setImage(image.getBytes());
        testRepository.save(test);
    }
}
