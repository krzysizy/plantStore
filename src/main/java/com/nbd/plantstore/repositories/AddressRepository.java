package com.nbd.plantstore.repositories;

import com.nbd.plantstore.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<Address> findById(Long id);

    @Query("select case when count(a)> 0 then true else false end from Address a where " +
            "a.city = :city and a.street = :street and a.street_number = :street_number")
    boolean existsAddressByCityAndStreetAndStreet_number(@Param("city") String city,
                                                         @Param("street") String street, @Param("street_number") Integer street_number);


    @Query("select a from Address a where " +
            "a.city = :city and a.street = :street and a.street_number = :street_number")
    Optional<Address> findByCityAndStreetAndStreet_number(@Param("city") String city,
                                                          @Param("street") String street, @Param("street_number") Integer street_number);
}