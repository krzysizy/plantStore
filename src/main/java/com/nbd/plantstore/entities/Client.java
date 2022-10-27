package com.nbd.plantstore.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "c_name", nullable = false)
    private String c_name;

    @Setter
    @Column(name = "c_surname", nullable = false)
    private String c_surname;

    @Setter
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @ManyToOne(cascade = CascadeType.REMOVE, optional = false)
    @JoinColumn(name = "address_id", nullable = false,
            foreignKey = @ForeignKey(
            name = "client_address_fk"
    ))
    private Address address;

    @OneToMany(mappedBy = "client")
    private List<Sale> currentSales = new ArrayList<>();

}