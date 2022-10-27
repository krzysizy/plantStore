package com.nbd.plantstore.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product_categorie", discriminatorType = DiscriminatorType.STRING)
@Table(name = "product")
public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Long id;

    @Setter
    @Column(name = "p_base_price", nullable = false)
    protected Double p_base_price;

    @Setter
    @PositiveOrZero
    @Column(name = "p_count", nullable = false)
    protected Integer p_count;

    @Column(name = "p_name", nullable = false, unique = true)
    protected String p_name;

}