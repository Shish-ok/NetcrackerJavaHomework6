package com.netcracker.repository;

import com.netcracker.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE customers SET surname = :newSurname WHERE id = :id", nativeQuery = true)
    void updateSurnameById(@Param("newSurname") String newSurname, @Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE customers SET district = :newDistrict WHERE id = :id", nativeQuery = true)
    void updateDistrictById(@Param("newDistrict") String newSurname, @Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE customers SET discount = :newDiscount WHERE id = :id", nativeQuery = true)
    void updateDiscountById(@Param("newDiscount") String newSurname, @Param("id") int id);
}