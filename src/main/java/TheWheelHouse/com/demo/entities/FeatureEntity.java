package TheWheelHouse.com.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Features")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeatureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_feature")
    private Long id;

    @Column(name = "feature", length = 35, nullable = false, unique = true)
    private String feature;
}
