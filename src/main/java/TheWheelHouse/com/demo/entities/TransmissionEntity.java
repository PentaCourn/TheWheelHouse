package TheWheelHouse.com.demo.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Transmissions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransmissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_transmission")
    private Long id;


    @Column(name = "type", length = 15, nullable = false, unique = true)
    private String transmission;

}
