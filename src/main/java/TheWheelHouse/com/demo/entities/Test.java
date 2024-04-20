package TheWheelHouse.com.demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Testing")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 15, nullable = false)
    private String name;

    @Column(name = "type", length = 15, nullable = false)
    private String type;

    private String path;
    private String url;
    @Lob
    @Column(name = "image")
    private byte[] image;

}
