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



    private String image;

   ;
}





