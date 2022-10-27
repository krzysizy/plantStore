package com.nbd.plantstore.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "s_product_count", nullable = false)
    private Integer s_product_count;

    @Column(name = "s_final_cost", nullable = false)
    private Double s_final_cost;

    @Column(name = "s_time", nullable = false )
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Timestamp s_time;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
    @JoinColumn(name = "client_id", nullable = false,
            foreignKey = @ForeignKey(
                    name = "sales_client_fk"
            ))
    private Client client;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false,
            foreignKey = @ForeignKey(
                    name = "sales_product_fk"
            ))
    private Product products;


}