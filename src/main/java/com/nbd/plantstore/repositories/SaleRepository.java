package com.nbd.plantstore.repositories;

import com.nbd.plantstore.entities.Client;
import com.nbd.plantstore.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    Optional<Sale> findById(Long id);

    @Query("select s from Sale s, Client c, Product p where " +
            "s.client.id = c.id and s.products.id = p.id and c.email = :email and p.p_name = :p_name")
    Optional<Sale> findSaleByEmailAndPName(@Param("email") String email, @Param("p_name") String pName);

    @Query("select case when count(s) > 0 then true else false end from Client c, Sale s, Product p where " +
            "s.client.id = c.id and s.products.id = p.id " +
            "and c.email = :email and p.p_name = :p_name ")
    boolean existsByEmailAndPName(@Param("email") String email, @Param("p_name") String pName);
}