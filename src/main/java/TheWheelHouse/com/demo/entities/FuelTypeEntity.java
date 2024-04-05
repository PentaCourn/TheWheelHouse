package TheWheelHouse.com.demo.entities;


import TheWheelHouse.com.demo.enums.Fuel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Fuel_Types")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuelTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_fuel_type")
    private Long id;

    @Column(name = "type", length = 15, nullable = false, unique = true)
    private Fuel fuelType;

}
