package TheWheelHouse.com.demo.controllers.individuals;

import TheWheelHouse.com.demo.entities.TransmissionEntity;
import TheWheelHouse.com.demo.services.TransmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transmissions")
@RequiredArgsConstructor
public class TransmissionController {
    private final TransmissionService transmissionService;

    @GetMapping("/")
    public ResponseEntity<List<TransmissionEntity>> getAllTransmissions() {
        return ResponseEntity.ok(transmissionService.getAllTransmissions());
    }
}
