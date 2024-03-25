package net.javaguides.springboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "meritOrder")
public class MeritOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false, unique=true)
    private String name;
    @Column(nullable=false)
    private String fuelType;
    @Column(nullable=false)
    private Float capacity;
    @Column(nullable=false)
    private Float op;
    @Column(nullable=false)
    private Float production;
    @Column(nullable=false)
    private Float price;
    @Column(nullable=false)
    private Float sfkCapacity;
}
