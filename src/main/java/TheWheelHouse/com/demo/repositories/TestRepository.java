package TheWheelHouse.com.demo.repositories;

import TheWheelHouse.com.demo.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {

}
