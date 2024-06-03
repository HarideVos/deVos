package com.binary.shop.services;

import com.binary.shop.dtos.ShopDto;
import com.binary.shop.entities.Shop;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShopService {

    public Shop createItem(@Valid ShopDto item);
    public List<Shop>  getAllItem();
    public Shop updateShop(long id, Shop shop);
    public Long deleteItem(Long id);
    public Shop getItemById(Long id);

}