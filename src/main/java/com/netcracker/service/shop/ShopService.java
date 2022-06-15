package com.netcracker.service.shop;

import com.netcracker.dto.shops.ShopNameDto;
import com.netcracker.dto.shops.UpdateShopDto;
import com.netcracker.model.Shop;

import java.util.List;

public interface ShopService {

    String deleteShopById(int id);

    String updateShop(int id, UpdateShopDto updateShopDto);

    Shop addShop(Shop shop);

    List<Shop> getAllShops();

    Shop getShopById(int id);

    List<ShopNameDto> getShopsOfTwoDistricts(String firstDistrict, String secondDistrict);

    String fullUpdateShop(int id, UpdateShopDto updateShopDto);
}