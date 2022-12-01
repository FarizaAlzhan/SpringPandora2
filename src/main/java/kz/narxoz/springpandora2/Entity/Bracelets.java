package kz.narxoz.springpandora2.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "Bracelets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bracelets {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    private Integer price;

    @Column(name = "oldprice",nullable = false)
    private Integer oldprice;


    @Column(name = "description",length = 300,nullable = false)
    private String description;


    private String image;

}
