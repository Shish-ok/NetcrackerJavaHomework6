package com.netcracker.repository;

import com.netcracker.dto.purchase.MonthDto;
import com.netcracker.dto.purchase.ProfitMoreThenNDto;
import com.netcracker.dto.purchase.SalesAmountDto;
import com.netcracker.dto.purchase.SurnameAndShopNameDto;
import com.netcracker.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    @Query(value = "SELECT DISTINCT new com.netcracker.dto.purchase.MonthDto(date) FROM Purchase")
    public List<MonthDto> getDates();

    @Query(value = "SELECT new com.netcracker.dto.purchase.SurnameAndShopNameDto(customerId.surname, shopId.name) FROM Purchase")
    List<SurnameAndShopNameDto> getSurnameAndShopName();

    @Query(value = "SELECT new com.netcracker.dto.purchase.SalesAmountDto(date, customerId.surname, customerId.discount, bookId.name, Purchase.count) FROM Purchase")
    List<SalesAmountDto> getAmountOfSales();

    @Query(value = "SELECT new com.netcracker.dto.purchase.ProfitMoreThenNDto(id, customerId.surname, date) FROM Purchase WHERE bookId.price >= :n")
    List<ProfitMoreThenNDto> getPurchaseProfitMoreThenN(int n);

    @Query(value = "SELECT new com.netcracker.dto.purchase.SurnameAndDistrictAndDateDto(customerId.surname, customerId.district, date) FROM Purchase WHERE customerId.district = shopId.location AND date >= :date ORDER BY date")
    List<SurnameAndShopNameDto> getPurchaseNotBeforeTheDate(Timestamp date);
}