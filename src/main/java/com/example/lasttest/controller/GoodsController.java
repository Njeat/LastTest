package com.example.lasttest.controller;

import com.example.lasttest.model.Category;
import com.example.lasttest.model.Goods;
import com.example.lasttest.model.GoodsImg;
import com.example.lasttest.model.GoodsLike;
import com.example.lasttest.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GoodsController {
    private final GoodsService goodsService;

    @PostMapping("/goods")
    public Goods createGoods(@RequestBody Goods goods){
        goodsService.createGoods(goods);
        return goods;
    }

    @GetMapping("/goods")
    public List<Goods> allGoods(){
        return goodsService.allGoods();
    }

    @GetMapping("/goods/{goodsId}")
    public Goods getGoodsById(@PathVariable("goodsId") int goodsId){
        return goodsService.getGoodsById(goodsId);
    }

    @GetMapping("/goods/like/{goodsId}")
    public int getGoodsLike(@PathVariable("goodsId") int goodsId){
        return goodsService.getGoodsLike(goodsId);
    }

    @GetMapping("/goods/img/{goodsId}")
    public List<GoodsImg> getGoodsImg(@PathVariable("goodsId") int goodsId){
        return goodsService.getGoodsImg(goodsId);
    }

    @GetMapping("/goods/category/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") int categoryId){
        return goodsService.getCategory(categoryId);
    }
}
