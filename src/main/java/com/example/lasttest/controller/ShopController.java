package com.example.lasttest.controller;

import com.example.lasttest.model.*;
import com.example.lasttest.service.ShopService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
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

    @GetMapping("/shop/review/{shopId}")
    public List<Review> getReviewByShopId(@PathVariable("shopId") int shopId){
        return shopService.getReviewByShopId(shopId);
    }

    @GetMapping("/shop/review/like/{reviewId}")
    public int countReview(@PathVariable("reviewId") int reviewId){
        return shopService.countReviewLike(reviewId);
    }

    @GetMapping("/shop/review/img/{reviewId}")
    public List<ReviewImg> getReviewImg(@PathVariable("reviewId") int reviewId){
        return shopService.getReviewImg(reviewId);
    }

    @GetMapping("/shop/news")
    public List<ShopNews> allNews(){
        return shopService.allNews();
    }

    @GetMapping("/shop/news/{shopId}")
    public List<ShopNews> getNewsByShopId(@PathVariable("shopId") int shopId){
        return shopService.getNewsByShopId(shopId);
    }

    @GetMapping("/shop/news/img/{shopNewsId}")
    public List<ShopNewsImg> getNewsImg(@PathVariable("shopNewsId") int shopNewsId){
        return shopService.getNewsImg(shopNewsId);
    }
}
