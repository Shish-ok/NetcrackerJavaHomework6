package com.netcracker.repository;

import com.netcracker.dto.shops.ShopNameDto;
import com.netcracker.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE shops SET name = :newName WHERE id = :id", nativeQuery = true)
    void updateNameById(@Param("newName") String newName, @Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE shops SET location = :newLocation WHERE id = :id", nativeQuery = true)
    void updateLocationById(@Param("newLocation") String newLocation, @Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE shops SET commission = :newCommission WHERE id = :id", nativeQuery = true)
    void updateCommissionById(@Param("newCommission") int newCommission, @Param("id") int id);

    @Query(value = "SELECT new com.netcracker.dto.shops.ShopNameDto(name) FROM Shop WHERE location = :firstDistrict OR location = :secondDistrict")
    List<ShopNameDto> getShopsOfTwoDistricts(String firstDistrict, String secondDistrict);
}