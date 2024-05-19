package TheWheelHouse.com.demo.controllers.individuals;

import TheWheelHouse.com.demo.entities.Test;
import TheWheelHouse.com.demo.services.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    /*@PostMapping("/add")
    public ResponseEntity<String> addTest(@RequestBody Test test) {
        testService.addTest(test);
        return ResponseEntity.ok("Test added successfully");
    }*/
/*
@PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> addTest(@RequestPart("test") Test test, @RequestPart("image") MultipartFile image) {
        try {
            testService.addTestWithImage(test, image);
            return ResponseEntity.ok("Test with image added successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
*/


    @PostMapping("/add")
    public ResponseEntity<String> addTest(@RequestBody Test test) {
        try {
            testService.addTest(test);
            return ResponseEntity.ok("Test with image added successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Test> getTestById(@PathVariable Long id) {
        return ResponseEntity.ok(testService.getTestById(id));
    }


    @CrossOrigin("http://localhost:3000/test")
    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) throws IOException {
        Test test = testService.getTestById(id);
        byte[] image = test.getImage();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);

        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }

    @CrossOrigin("http://localhost:3000/test")
    @GetMapping("/{id}/image-path")
    public ResponseEntity<String> getImagePath(@PathVariable Long id) {
        Test test = testService.getTestById(id);
        String userHome = System.getProperty("user.home");
        String desktopPath = test.getPath();
        return ResponseEntity.ok(desktopPath);
    }

    @CrossOrigin("http://localhost:3000/test")
    @GetMapping("/{id}/image-url")
    public ResponseEntity<String> getImageUrl(@PathVariable Long id) {
        Test test = testService.getTestById(id);
        String imageUrl = test.getUrl();

        return ResponseEntity.ok(imageUrl);
    }
}
