package com.example.lasttest.service;

import com.example.lasttest.mapper.GoodsMapper;
import com.example.lasttest.model.Category;
import com.example.lasttest.model.Goods;
import com.example.lasttest.model.GoodsImg;
import com.example.lasttest.model.GoodsLike;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Getter
@Slf4j
public class GoodsService {
    private final GoodsMapper goodsMapper;

    public void createGoods(Goods goods){
        goodsMapper.createGoods(goods);
    }

    public List<Goods> allGoods(){
        return goodsMapper.allGoods();
    }

    public Goods getGoodsById(int goodsId){
        return goodsMapper.getGoodsById(goodsId);
    }

    public List<Goods> getGoodsByUserId(int userId){
        return goodsMapper.getGoodsByUserId(userId);
    }

    public int getGoodsLike(int goodsId){
        return goodsMapper.getGoodsLike(goodsId);
    }

    public List<GoodsImg> getGoodsImg(int goodsId){
        return goodsMapper.getGoodsImg(goodsId);
    }

    public Category getCategory(int categoryId){
        return goodsMapper.getCategory(categoryId);
    }
}
