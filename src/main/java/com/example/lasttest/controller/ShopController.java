package com.example.lasttest.controller;

import com.example.lasttest.model.Shop;
import com.example.lasttest.model.ShopImg;
import com.example.lasttest.service.ShopService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;

    @PostMapping("/shop")
    public Shop createShop(@RequestBody Shop shop){
        shopService.createShop(shop);
        return shop;
    }

    @GetMapping("/shop")
    public List<Shop> allShop(){
        return shopService.allShop();
    }

    @GetMapping("/shop/{shopId}")
    public Shop getShopById(@PathVariable("shopId") int shopId){
        return shopService.getShopById(shopId);
    }

    @GetMapping("/shop/img/{shopId}")
    public List<ShopImg> getShopImg(@PathVariable("shopId") int shopId){
        return shopService.getShopImg(shopId);
    }

    @GetMapping("/shop/custom/{shopId}")
    public int countCustom(@PathVariable("shopId") int shopId){
        return shopService.countCustom(shopId);
    }
}
