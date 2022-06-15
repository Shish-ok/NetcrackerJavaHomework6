package com.netcracker.rest;

import com.netcracker.dto.purchase.*;
import com.netcracker.model.Purchase;
import com.netcracker.service.purchase.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/purchase/")
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    @Operation(summary = "Add new purchase")
    @PostMapping("add")
    public ResponseEntity<Purchase> addPurchase(@RequestBody Purchase purchase) {
        return ResponseEntity.ok(purchaseService.addPurchase(purchase));
    }

    @Operation(summary = "Get all purchases")
    @GetMapping("all")
    public ResponseEntity<List<Purchase>> getAllPurchase() {
        return ResponseEntity.ok(purchaseService.getAllPurchase());
    }

    @Operation(summary = "Get purchase by id")
    @GetMapping("{id}")
    public ResponseEntity<Purchase> getPurchaseById(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(purchaseService.getPurchaseById(id));
    }

    @Operation(summary = "Partial purchase update by id")
    @PatchMapping("update/{id}")
    public ResponseEntity<String> updatePurchase(@PathVariable(value = "id") int id, @RequestBody UpdatePurchaseDto updatePurchaseDto) {
        return ResponseEntity.ok(purchaseService.updatePurchase(id, updatePurchaseDto));
    }

    @Operation(summary = "Full customer update by id")
    @PutMapping("full_update/{id}")
    public ResponseEntity<String> fullUpdatePurchase(@PathVariable(value = "id") int id, @RequestBody UpdatePurchaseDto updatePurchaseDto) {
        return ResponseEntity.ok(purchaseService.fullUpdatePurchase(id, updatePurchaseDto));
    }

    @Operation(summary = "Delete customer by id")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deletePurchase(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(purchaseService.deletePurchaseById(id));
    }

    @Operation(summary = "Get all different dates")
    @GetMapping("dates")
    public ResponseEntity<List<MonthDto>> getDistinctDates() {
        return ResponseEntity.ok(purchaseService.getDates());
    }

    @Operation(summary = "Get purchase history by customer's surname and name of shop")
    @GetMapping("history")
    public ResponseEntity<List<SurnameAndShopNameDto>> getHistory() {
        return ResponseEntity.ok(purchaseService.getPurchaseHistoryBySurnameAndShopName());
    }

    @Operation(summary = "Get date, last name of the buyer, discount, title and number of books purchased")
    @GetMapping("sales_amount")
    public ResponseEntity<List<SalesAmountDto>> getAmountOfSales() {
        return ResponseEntity.ok(purchaseService.getAmountOfSales());
    }

    @Operation(summary = "Get orders for an amount greater than N")
    @GetMapping("purchases_more_then_n/{n}")
    public ResponseEntity<List<ProfitMoreThenNDto>> getPurchaseProfitMoreThenN(@PathVariable(value = "n") int n) {
        return ResponseEntity.ok(purchaseService.getPurchaseProfitMoreThenN(n));
    }

    @Operation(summary = "Get purchases made in own district not earlier certain time")
    @GetMapping("purchase_mage_not_earlier/{date}")
    public ResponseEntity<List<SurnameAndShopNameDto>> getPurchaseNotBeforeTheDate(@PathVariable(value = "date") String date) {
        return ResponseEntity.ok(purchaseService.getPurchaseNotBeforeTheDate(Date.valueOf(date)));
    }

    @Operation(summary = "Get from different district, except X, and between left and right percents")
    @PostMapping("from_different_district")
    public ResponseEntity<List<String>> getShopsFromLegalLocationAndDiscountBetweenTwoValues(@RequestBody LeftRightBanDistrictDto dto) {
        return ResponseEntity.ok(purchaseService.getShopsFromLegalLocationAndDiscountBetweenTwoValues(dto.getLeft(), dto.getRight(), dto.getBanDistrict()));
    }

    @Operation(summary = "Get information of books acquired in the warehouse district the stock of which is left more than n")
    @GetMapping("books_from_one_district/{n}")
    public ResponseEntity<List<BookFromOneDistrictDto>> getBookFromOneDistrict(@PathVariable(value = "n") int n) {
        return ResponseEntity.ok(purchaseService.getBookFromOneDistrict(n));
    }

}