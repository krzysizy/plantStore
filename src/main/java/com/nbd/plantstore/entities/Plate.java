package com.nbd.plantstore.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("plate")
public class Plate extends Product {

    @Setter
    @Column(name = "height")
    private Integer height;

    @Setter
    @Column(name = "period")
    private String period;

    @Builder
    public Plate(Long id, Double p_base_price, Integer p_count, String p_name, Integer height, String period) {
        super(id, p_base_price, p_count, p_name);
        this.height = height;
        this.period = period;
    }

}