package TheWheelHouse.com.demo.controllers.individuals;

import TheWheelHouse.com.demo.entities.ColorEntity;
import TheWheelHouse.com.demo.services.ColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/colors")
@RequiredArgsConstructor
public class ColorController {
    private final ColorService colorService;

    @GetMapping("/")
    public ResponseEntity<List<ColorEntity>> getAllColors(){
        List<ColorEntity> colors = colorService.getAllColors();
        return ResponseEntity.ok(colors);
    }
}