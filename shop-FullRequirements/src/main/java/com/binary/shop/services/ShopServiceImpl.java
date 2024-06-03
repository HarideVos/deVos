package com.binary.shop.services;

import com.binary.shop.dtos.ShopDto;
import com.binary.shop.entities.Shop;
import com.binary.shop.exceptions.ItemNotFoundException;
import com.binary.shop.repositories.ShopRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public Shop createItem(@Valid ShopDto item) {
        Shop shop = new Shop();
        shop.setItem(item.getItem());
        shop.setType(item.getType());
        shop.setPrice(item.getPrice());
        return shopRepository.save(shop);
    }

    @Override
    public List<Shop> getAllItem() {
        return shopRepository.findAll();
    }

    @Override
    public Shop updateShop(long id, Shop shop) {
        Optional<Shop> optionalShop = shopRepository.findById((int) id);
        if (optionalShop.isPresent()) {
            Shop existingShop = optionalShop.get();
            existingShop.setItem(shop.getItem());
            existingShop.setType(shop.getType());
            existingShop.setPrice(shop.getPrice());
            return shopRepository.save(existingShop);
        } else {
            throw new ItemNotFoundException("Item not found with id: " + id);
        }
    }

    @Override
    public Long deleteItem(Long id) {
        shopRepository.deleteById(Math.toIntExact(id));
        return id;
    }

    @Override
    public Shop getItemById(Long id) {
        Optional<Shop> optionalShop = shopRepository.findById(Math.toIntExact(id));
        return optionalShop.orElse(null);
    }
}