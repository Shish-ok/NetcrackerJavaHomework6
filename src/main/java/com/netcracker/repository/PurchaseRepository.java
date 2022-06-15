package com.netcracker.repository;

import com.netcracker.dto.purchase.*;
import com.netcracker.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    @Query(value = "SELECT DISTINCT new com.netcracker.dto.purchase.MonthDto(p.date) FROM Purchase p")
    public List<MonthDto> getDates();

    @Query(value = "SELECT new com.netcracker.dto.purchase.SurnameAndShopNameDto(customerId.surname, shopId.name) FROM Purchase")
    List<SurnameAndShopNameDto> getSurnameAndShopName();

    @Query(value = "SELECT new com.netcracker.dto.purchase.SalesAmountDto(date, customerId.surname, customerId.discount, bookId.name, amount) FROM Purchase")
    List<SalesAmountDto> getAmountOfSales();

    @Query(value = "SELECT shopId.name FROM Purchase WHERE shopId.location <> :banLocation AND customerId.discount >= :left AND customerId.discount <= :right")
    List<String> getShopsFromLegalLocationAndDiscountBetweenTwoValues(String banLocation, int left, int right);

    @Query(value = "SELECT new com.netcracker.dto.purchase.ProfitMoreThenNDto(id, customerId.surname, date) FROM Purchase WHERE bookId.price >= :n")
    List<ProfitMoreThenNDto> getPurchaseProfitMoreThenN(int n);

    @Query(value = "SELECT new com.netcracker.dto.purchase.SurnameAndDistrictAndDateDto(customerId.surname, customerId.district, date) FROM Purchase WHERE customerId.district = shopId.location AND date >= :date ORDER BY date")
    List<SurnameAndShopNameDto> getPurchaseNotBeforeTheDate(Date date);

    @Query(value = "SELECT new com.netcracker.dto.purchase.BookFromOneDistrictDto(bookId.name, bookId.warehouse, bookId.count, bookId.price) FROM Purchase WHERE shopId.location = bookId.warehouse AND bookId.count > :n ORDER BY bookId.price")
    List<BookFromOneDistrictDto> getBookFromOneDistrict(int n);
}