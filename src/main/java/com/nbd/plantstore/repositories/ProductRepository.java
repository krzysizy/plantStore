package com.nbd.plantstore.repositories;


import com.nbd.plantstore.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {



    Optional<Product> findById(Long id);


    @Query("select p from Product p where " +
            "p.p_name = :p_name")
    Optional<Product> findProductByName(@Param("p_name")String p_name);


    @Query("select case when count(p) > 0 then true else false end from Product p where " +
            "p.p_name = :p_name")
    boolean existsByName(@Param("p_name")String p_name);

    @Modifying
    @Query("update Product p set p.p_count = p.p_count - :soldPCout where p.id = :id")
    void changeCount(@Param("soldPCout") Integer soldCount, Long id);

    @Modifying
    @Query("update Product p set p.p_base_price = :basePrice where p.id = :id")
    void updateBasePrice(@Param("basePrice") Double basePrice, Long id);

}