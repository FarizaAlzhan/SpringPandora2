package kz.narxoz.springpandora2.Entity;


import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Table(name = "Rings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rings {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    private Integer price;

    @Column(name = "oldprice", nullable = false)
    private Integer oldprice;


    @Column(name = "description",length = 300,nullable = false)
    private String description;

    @Column(name = "characteristics", nullable = false)
    private String characteristics;

    @Column(name = "new_product", nullable = false)
    private Boolean New_product;

    private String image;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;
}




