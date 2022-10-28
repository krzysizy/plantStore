package com.nbd.plantstore.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("seed")
public class Seed extends Product {

    @Setter
    @Column(name = "weight")
    private Integer weight;

    @Builder
    public Seed(Long id, Double p_base_price, Integer p_count, String p_name, Integer weight, Integer version) {
        super(id, p_base_price, p_count, p_name, version);
        this.weight = weight;
    }

}