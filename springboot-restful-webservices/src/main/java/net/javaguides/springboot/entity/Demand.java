package net.javaguides.springboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "demand")
public class Demand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @Column(nullable=false)
    private Date date;
    @Column(nullable=false)
    private Integer hour;
    @Column(nullable=false)
    private Float residual;
    @Column(nullable=false)
    private Float marketPrice;
    @Column(nullable=false)
    private Float sfkPrice;
}
