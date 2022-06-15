package com.netcracker.service.shop;

import com.netcracker.dto.shops.ShopNameDto;
import com.netcracker.dto.shops.UpdateShopDto;
import com.netcracker.exception.NotFoundException;
import com.netcracker.model.Shop;
import com.netcracker.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    private Shop shop;

    @Override
    public String deleteShopById(int id) {
        shop = shopRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found shop with id: " + id));
        shopRepository.deleteById(id);
        return "Shop \"" + shop.getName() + "\" (id:" + id + ") — successfully deleted!";
    }

    @Override
    public String updateShop(int id, UpdateShopDto updateShopDto) {
        shop = shopRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found shop with id: " + id));

        StringBuilder updateMessage = new StringBuilder();

        if (updateShopDto.getName() != null) {
            shopRepository.updateNameById(updateShopDto.getName(), id);
            updateMessage.append("Name successfully updated: old name \"" + shop.getName() + "\", new name \"" + updateShopDto.getName() + "\"\n");
        }

        if (updateShopDto.getLocation() != null) {
            shopRepository.updateLocationById(updateShopDto.getLocation(), id);
            updateMessage.append("Location successfully updated: old location \"" + shop.getLocation() + "\", new location \"" + updateShopDto.getLocation() + "\"\n");
        }

        if (updateShopDto.getCommission() != null) {
            shopRepository.updateCommissionById(updateShopDto.getCommission(), id);
            updateMessage.append("Commission successfully updated: old commission " + shop.getCommission() + ", new commission " + updateShopDto.getCommission());
        }

        return updateMessage.toString();
    }

    @Override
    public Shop addShop(Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    @Override
    public Shop getShopById(int id) {
        return shopRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found shop with id: " + id));
    }

    @Override
    public List<ShopNameDto> getShopsOfTwoDistricts(String firstDistrict, String secondDistrict) {
        return shopRepository.getShopsOfTwoDistricts(firstDistrict, secondDistrict);
    }

    @Override
    public String fullUpdateShop(int id, UpdateShopDto updateShopDto) {
        shop = shopRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found shop with id: " + id));

        shop.setName(updateShopDto.getName());
        shop.setLocation(updateShopDto.getLocation());
        shop.setCommission(updateShopDto.getCommission());

        shopRepository.save(shop);

        return "Shop with id: " + id + " — successfully update!";
    }
}
