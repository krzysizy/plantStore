package com.nbd.plantstore.repositories;

import com.nbd.plantstore.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("select a from Address a where a.id = :id")
    Optional<Address> findAddress(@Param("id") Long id);

    @Query("select case when count(a)> 0 then true else false end from Address a where " +
            "a.city = :city and a.street = :street and a.street_number = :street_number")
    boolean existsAddressByCityAndStreetAndStreet_number(@Param("city") String city,
                                                         @Param("street") String street, @Param("street_number") Integer street_number);
    @Modifying
    @Query("update Address a set a.street = :newStreet where a.id = :id")
    void updateStreet(@Param("newStreet")String newStreet, @Param("id")Long id);

    @Modifying
    @Query("update Address a set a.city = :newCity where a.id = :id")
    void updateCity(@Param("newCity")String newCity, @Param("id")Long id);
    @Modifying
    @Query("update Address a set a.street_number = :newStreetNum where a.id = :id")
    void updateStreetNum(@Param("newStreetNum")Integer newStreetNum, @Param("id")Long id);

    @Query("select a from Address a where " +
            "a.city = :city and a.street = :street and a.street_number = :street_number")
    Optional<Address> findByCityAndStreetAndStreet_number(@Param("city") String city,
                                                          @Param("street") String street, @Param("street_number") Integer street_number);
}