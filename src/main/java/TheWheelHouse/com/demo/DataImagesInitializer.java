package TheWheelHouse.com.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DataImagesInitializer {

    private static final String DATA_IMAGES_PATH = "./DataImages";

    //това ще се извика след като spring контекста се създаде
    @PostConstruct
    public void init() {
        File dataImagesDir = new File(DATA_IMAGES_PATH);
        if (!dataImagesDir.exists()) {
            boolean dirCreated = dataImagesDir.mkdirs();
            if (dirCreated) {
                System.out.println("DataImages directory created successfully.");
            } else {
                System.err.println("Failed to create DataImages directory.");
            }
        }
    }
}