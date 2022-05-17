package com.example.lasttest.service;

import com.example.lasttest.mapper.ShopMapper;
import com.example.lasttest.model.Shop;
import com.example.lasttest.model.ShopImg;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Getter
@Slf4j
public class ShopService {
    private final ShopMapper shopMapper;

    public Shop createShop(Shop shop){
        return shopMapper.createShop(shop);
    }

    public List<Shop> allShop(){
        return shopMapper.allShop();
    }

    public Shop getShopById(int shopId){
        return shopMapper.getShopById(shopId);
    }

    public List<ShopImg> getShopImg(int shopId){
        return shopMapper.getShopImg(shopId);
    }

    public int countCustom(int shopId){
        return shopMapper.countCustom(shopId);
    }
}
