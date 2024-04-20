package TheWheelHouse.com.demo.controllers.individuals;

import TheWheelHouse.com.demo.entities.Test;
import TheWheelHouse.com.demo.services.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @PostMapping("/add")
    public ResponseEntity<String> addTest(@RequestBody Test test) {
        testService.addTest(test);
        return ResponseEntity.ok("Test added successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Test> getTestById(@PathVariable Long id) {
        return ResponseEntity.ok(testService.getTestById(id));
    }
}
