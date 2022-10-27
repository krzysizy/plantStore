package com.nbd.plantstore.repositories;


import com.nbd.plantstore.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
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

}