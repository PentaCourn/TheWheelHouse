package TheWheelHouse.com.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    @ExceptionHandler(value =  {IllegalAccessException.class})
    public ResponseEntity<String> handleException(IllegalAccessException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
