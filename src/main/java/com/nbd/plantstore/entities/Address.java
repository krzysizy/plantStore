package com.nbd.plantstore.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Setter
    @Column(name = "street", nullable = false)
    private String street;

    @Setter
    @Column(name = "street_number", nullable = false)
    private Integer street_number;

    @Setter
    @Column(name = "city", nullable = false)
    private String city;


}