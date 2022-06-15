package com.netcracker.service.purchase;

import com.netcracker.dto.purchase.*;
import com.netcracker.model.Purchase;

import java.util.Date;
import java.util.List;

public interface PurchaseService {

    String deletePurchaseById(int id);

    String updatePurchase(int id, UpdatePurchaseDto updatePurchaseDto);

    Purchase addPurchase(Purchase purchase);

    List<Purchase> getAllPurchase();

    Purchase getPurchaseById(int id);

    List<MonthDto> getDates();

    List<SurnameAndShopNameDto> getPurchaseHistoryBySurnameAndShopName();

    List<SalesAmountDto> getAmountOfSales();

    List<ProfitMoreThenNDto> getPurchaseProfitMoreThenN(int n);

    List<String> getShopsFromLegalLocationAndDiscountBetweenTwoValues(int left, int right, String banDistrict);

    List<SurnameAndShopNameDto> getPurchaseNotBeforeTheDate(Date date);

    List<BookFromOneDistrictDto> getBookFromOneDistrict(int n);

    String fullUpdatePurchase(int id, UpdatePurchaseDto updatePurchaseDto);

}