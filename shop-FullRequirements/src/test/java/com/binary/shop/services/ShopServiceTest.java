package com.binary.shop.services;

import com.binary.shop.dtos.ShopDto;
import com.binary.shop.entities.Shop;
import com.binary.shop.exceptions.ItemNotFoundException;
import com.binary.shop.repositories.ShopRepository;
import com.binary.shop.services.ShopServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ShopServiceTest {

    @Mock
    private ShopRepository shopRepository;

    @InjectMocks
    private ShopServiceImpl shopService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateItem() {
        ShopDto shopDto = new ShopDto("item", "type", 10.0);
        Shop shop = new Shop(1L, "item", "brand", "model", "type", 10, 10.0, "make", null);

        when(shopRepository.save(any(Shop.class))).thenReturn(shop);

        Shop createdShop = shopService.createItem(shopDto);

        assertEquals(shop, createdShop);
        verify(shopRepository, times(1)).save(any(Shop.class));
    }

    @Test
    public void testGetAllItem() {
        List<Shop> shopList = new ArrayList<>();
        shopList.add(new Shop(1L, "item1", "brand1", "model1", "type1", 10, 10.0, "make1", null));
        shopList.add(new Shop(2L, "item2", "brand2", "model2", "type2", 20, 20.0, "make2", null));

        when(shopRepository.findAll()).thenReturn(shopList);

        List<Shop> retrievedShopList = shopService.getAllItem();

        assertEquals(2, retrievedShopList.size());
        assertEquals(shopList, retrievedShopList);
    }

    @Test
    public void testUpdateShop_WhenItemExists() {
        long id = 1L;
        Shop updatedShop = new Shop(1L, "updatedItem", "updatedBrand", "updatedModel", "updatedType", 20, 15.0, "updatedMake", null);
        Optional<Shop> optionalShop = Optional.of(new Shop(1L, "oldItem", "oldBrand", "oldModel", "oldType", 10, 10.0, "oldMake", null));

        when(shopRepository.findById((int) id)).thenReturn(optionalShop);
        when(shopRepository.save(any(Shop.class))).thenReturn(updatedShop);

        Shop result = shopService.updateShop(id, updatedShop);

        assertEquals(updatedShop, result);
    }

    @Test
    public void testUpdateShop_WhenItemDoesNotExist() {
        long id = 1L;
        Shop updatedShop = new Shop(1L, "updatedItem", "updatedBrand", "updatedModel", "updatedType", 20, 15.0, "updatedMake", null);
        Optional<Shop> optionalShop = Optional.empty();

        when(shopRepository.findById((int) id)).thenReturn(optionalShop);

        try {
            shopService.updateShop(id, updatedShop);
        } catch (ItemNotFoundException e) {
            assertEquals("Item not found with id: " + id, e.getMessage());
        }
    }

    @Test
    public void testDeleteItem() {
        long id = 1L;
        doNothing().when(shopRepository).deleteById((int) id);

        Long result = shopService.deleteItem(id);

        assertEquals(id, result);
        verify(shopRepository, times(1)).deleteById((int) id);
    }

    @Test
    public void testGetItemById_WhenItemExists() {
        long id = 1L;
        Optional<Shop> optionalShop = Optional.of(new Shop(1L, "item", "brand", "model", "type", 10, 10.0, "make", null));

        when(shopRepository.findById((int) id)).thenReturn(optionalShop);

        Shop result = shopService.getItemById(id);

        assertEquals(optionalShop.get(), result);
    }

    @Test
    public void testGetItemById_WhenItemDoesNotExist() {
        long id = 1L;
        Optional<Shop> optionalShop = Optional.empty();

        when(shopRepository.findById((int) id)).thenReturn(optionalShop);

        Shop result = shopService.getItemById(id);

        assertEquals(null, result);
    }
}