package TheWheelHouse.com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication
{

	public static void main(String[] args) {
		//activate the window
		new MyAppGUI();
		//run the spring application
		SpringApplication.run(DemoApplication.class, args);
	}

}
