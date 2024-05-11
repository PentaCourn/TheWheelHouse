package TheWheelHouse.com.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Images")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_image")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private CarEntity car;

    @Column(name = "image_name", length = 35, nullable = false)
    private String imageName;

    @Column(name = "image_type", length = 15, nullable = false)
    private String imageType;

    @Column(name = "image_path", length = 255, nullable = false)
    private String imagePath;

    @Lob
    @Column(name = "image")
    private byte[] image;
}
