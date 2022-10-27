package com.nbd.plantstore.repositories;



import com.nbd.plantstore.entities.Address;
import com.nbd.plantstore.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findById(Long id);

    @Query("select c from Client c where " +
            "c.email = :email ")
    Optional<Client> findClientByEmail(@Param("email")String email);

    @Query("select case when count(c) > 0 then true else false end from Client c where " +
            "c.email = :email")
    boolean existsByEmail(@Param("email")String email);


}