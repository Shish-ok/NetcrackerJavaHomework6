package com.netcracker.rest;

import com.netcracker.dto.shops.DistrictsDto;
import com.netcracker.dto.shops.ShopNameDto;
import com.netcracker.dto.shops.UpdateShopDto;
import com.netcracker.model.Shop;
import com.netcracker.service.shop.ShopService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shops/")
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    @Operation(summary = "Delete shop by id")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteShop(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(shopService.deleteShopById(id));
    }

    @Operation(summary = "Partial shop update by id")
    @PatchMapping("update/{id}")
    public ResponseEntity<String> updateShop(@PathVariable(value = "id") int id, @RequestBody UpdateShopDto updateShopDto) {
        return ResponseEntity.ok(shopService.updateShop(id, updateShopDto));
    }

    @Operation(summary = "Add shop")
    @PostMapping("add")
    public ResponseEntity<Shop> addShop(@RequestBody Shop shop) {
        return ResponseEntity.ok(shopService.addShop(shop));
    }

    @Operation(summary = "Get all shops")
    @GetMapping("all")
    public ResponseEntity<List<Shop>> getAllShops() {
        return ResponseEntity.ok(shopService.getAllShops());
    }

    @Operation(summary = "Get shop by id")
    @GetMapping("{id}")
    public ResponseEntity<Shop> getShopById(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(shopService.getShopById(id));
    }

    @Operation(summary = "Shops located in two districts")
    @PostMapping("location")
    public ResponseEntity<List<ShopNameDto>> getShopsOfTwoDistricts(@RequestBody DistrictsDto districtsDto) {
        return ResponseEntity.ok(shopService.getShopsOfTwoDistricts(districtsDto.getFirstDistrict(), districtsDto.getSecondDistrict()));
    }

    @Operation(summary = "Full shop update by id")
    @PutMapping("full_update/{id}")
    public ResponseEntity<String> fullUpdateShop(@PathVariable(value = "id") int id, UpdateShopDto updateShopDto) {
        return ResponseEntity.ok(shopService.fullUpdateShop(id, updateShopDto));
    }
}