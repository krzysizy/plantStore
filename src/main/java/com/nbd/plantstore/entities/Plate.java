package com.nbd.plantstore.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("plate")
public class Plate extends Product {
    @Column(name = "height")
    private Integer height;

    @Column(name = "period")
    private String period;

}