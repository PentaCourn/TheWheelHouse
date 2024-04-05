package TheWheelHouse.com.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Models")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_model")
    private Long id;

    //това е връзката между таблиците Brand и Model
    //един Brand може да има много модели
    //затова е ManyToOne
    //малко е странно, че е ManyToOne, но така е
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandEntity brandEntity;

    @Column(name = "model_name", length = 15, nullable = false, unique = true)
    private String modelName;
}
