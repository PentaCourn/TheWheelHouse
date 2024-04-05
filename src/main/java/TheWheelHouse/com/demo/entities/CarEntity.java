package TheWheelHouse.com.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Cars")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_car")
    private Long id;

    @Column(name = "VIN", length = 17, nullable = false, unique = true)
    private String VIN;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private ModelEntity modelEntity;

    @ManyToOne
    @JoinColumn(name = "transmission_id")
    private TransmissionEntity transmissionEntity;

    @ManyToOne
    @JoinColumn(name = "fuel_type_id")
    private FuelTypeEntity fuelTypeEntity;

    @ManyToOne
    @JoinColumn(name = "interior_color_id")
    private ColorEntity interiorColorEntity;

    @ManyToOne
    @JoinColumn(name = "exterior_color_id")
    private ColorEntity exteriorColorEntity;

    @Column(name = "number_of_doors", nullable = false)
    private Integer numberOfDoors;

    @Column(name = "mileage", nullable = false)
    private Integer mileage;

    @Column(name = "year_of_production", nullable = false)
    private Integer yearOfProduction;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;
}
