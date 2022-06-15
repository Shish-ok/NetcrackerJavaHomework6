package com.netcracker.service.purchase;

import com.netcracker.dto.purchase.MonthDto;
import com.netcracker.dto.purchase.SalesAmountDto;
import com.netcracker.dto.purchase.SurnameAndShopNameDto;
import com.netcracker.dto.purchase.UpdatePurchaseDto;
import com.netcracker.model.Purchase;

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

    String fullUpdatePurchase(int id, UpdatePurchaseDto updatePurchaseDto);

}