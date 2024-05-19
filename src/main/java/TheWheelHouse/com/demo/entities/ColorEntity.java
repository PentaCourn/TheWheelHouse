package TheWheelHouse.com.demo.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Colors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_color")
    private Long id;


    @Column(name = "color", length = 15, nullable = false, unique = true)
    private String color;
}
