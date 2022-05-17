package com.example.lasttest.service;

import antlr.collections.impl.LList;
import com.example.lasttest.mapper.ShopMapper;
import com.example.lasttest.model.Review;
import com.example.lasttest.model.ReviewImg;
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

    public List<Review> getReviewByShopId(int shopId){
        return shopMapper.getReviewByShopId(shopId);
    }

    public int countReviewLike(int reviewId){
        return shopMapper.countReviewLike(reviewId);
    }

    public List<ReviewImg> getReviewImg(int reviewId){
        return shopMapper.getReviewImg(reviewId);
    }
}
