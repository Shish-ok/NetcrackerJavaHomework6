package com.netcracker.rest;

import com.netcracker.dto.purchase.MonthDto;
import com.netcracker.dto.purchase.SalesAmountDto;
import com.netcracker.dto.purchase.SurnameAndShopNameDto;
import com.netcracker.dto.purchase.UpdatePurchaseDto;
import com.netcracker.model.Purchase;
import com.netcracker.service.purchase.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


}