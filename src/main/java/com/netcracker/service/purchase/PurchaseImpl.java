package com.netcracker.service.purchase;

import com.netcracker.dto.purchase.*;
import com.netcracker.exception.NotFoundException;
import com.netcracker.model.Purchase;
import com.netcracker.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseImpl implements PurchaseService{

    private final PurchaseRepository purchaseRepository;

    private Purchase purchase;

    @Override
    public String deletePurchaseById(int id) {
        purchase = purchaseRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found purchase with id: " + id));
        purchaseRepository.deleteById(id);

        return "Purchase " + id + "— successfully deleted!";
    }

    @Override
    public String updatePurchase(int id, UpdatePurchaseDto updatePurchaseDto) {
        purchase = purchaseRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found purchase with id: " + id));

        StringBuilder updateMessage = new StringBuilder();

        if (updatePurchaseDto.getDate() != null) {
            updateMessage.append("Date successfully updated: old date " + purchase.getDate() + ", new date " + updatePurchaseDto.getDate() + "\n");
            purchase.setDate(updatePurchaseDto.getDate());
        }

        if (updatePurchaseDto.getShopId() != null) {
            updateMessage.append("Id of shop successfully updated: old id " + purchase.getShopId().getId() + ", new id " + updatePurchaseDto.getShopId().getId() + "\n");
            purchase.setShopId(updatePurchaseDto.getShopId());
        }

        if (updatePurchaseDto.getCustomerId() != null) {
            updateMessage.append("Id of customer successfully updated: old id " + purchase.getCustomerId().getId() + ", new id " + updatePurchaseDto.getCustomerId().getId() + "\n");
            purchase.setCustomerId(updatePurchaseDto.getCustomerId());
        }

        if (updatePurchaseDto.getBookId() != null) {
            updateMessage.append("Id of book successfully updated: old id " + purchase.getBookId().getId() + ", new id " + updatePurchaseDto.getBookId().getId() + "\n");
            purchase.setBookId(updatePurchaseDto.getBookId());
        }

        if (updatePurchaseDto.getCount() != null) {
            updateMessage.append("Count of book successfully updated: old count " + purchase.getAmount() + ", new count " + updatePurchaseDto.getCount() + "\n");
            purchase.setAmount(updatePurchaseDto.getCount());
        }

        if(updatePurchaseDto.getPrice() != null) {
            updateMessage.append("Price of book successfully updated: old price " + purchase.getPrice() + ", new price " + updatePurchaseDto.getPrice());
            purchase.setPrice(updatePurchaseDto.getPrice());
        }

        purchaseRepository.save(purchase);

        return updateMessage.toString();
    }

    @Override
    public Purchase addPurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    @Override
    public List<Purchase> getAllPurchase() {
        return purchaseRepository.findAll();
    }

    @Override
    public Purchase getPurchaseById(int id) {
        return purchaseRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found purchase with id: " + id));
    }

    @Override
    public List<MonthDto> getDates() {
        return purchaseRepository.getDates();
    }

    @Override
    public List<SurnameAndShopNameDto> getPurchaseHistoryBySurnameAndShopName() {
        return purchaseRepository.getSurnameAndShopName();
    }

    @Override
    public List<SalesAmountDto> getAmountOfSales() {
        return purchaseRepository.getAmountOfSales();
    }

    @Override
    public List<ProfitMoreThenNDto> getPurchaseProfitMoreThenN(int n) {
        return purchaseRepository.getPurchaseProfitMoreThenN(n);
    }

    @Override
    public List<String> getShopsFromLegalLocationAndDiscountBetweenTwoValues(int left, int right, String banDistrict) {
        return purchaseRepository.getShopsFromLegalLocationAndDiscountBetweenTwoValues(banDistrict, left, right);
    }

    @Override
    public List<SurnameAndShopNameDto> getPurchaseNotBeforeTheDate(Date date) {
        return purchaseRepository.getPurchaseNotBeforeTheDate(date);
    }

    @Override
    public List<BookFromOneDistrictDto> getBookFromOneDistrict(int n) {
        return purchaseRepository.getBookFromOneDistrict(n);
    }

    @Override
    public String fullUpdatePurchase(int id, UpdatePurchaseDto updatePurchaseDto) {
        purchase = purchaseRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found purchase with id: " + id));

        purchase.setBookId(updatePurchaseDto.getBookId());
        purchase.setCustomerId(updatePurchaseDto.getCustomerId());
        purchase.setDate(updatePurchaseDto.getDate());
        purchase.setShopId(updatePurchaseDto.getShopId());
        purchase.setAmount(updatePurchaseDto.getCount());
        purchase.setPrice(updatePurchaseDto.getPrice());

        purchaseRepository.save(purchase);

        return "Purchase with id: " + id + " — successfully update!";
    }
}
