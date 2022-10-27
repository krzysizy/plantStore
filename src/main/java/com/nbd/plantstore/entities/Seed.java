package com.nbd.plantstore.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("seed")
public class Seed extends Product {

    @Column(name = "weight", nullable = false)
    private Integer weight;

}