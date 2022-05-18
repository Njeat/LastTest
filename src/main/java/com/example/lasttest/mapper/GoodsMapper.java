package com.example.lasttest.mapper;

import com.example.lasttest.model.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsMapper {

    @Insert("INSERT INTO goods (userId, goodsTitle, categoryId, goodsDetail, goodsView, goodsPrice) VALUES" +
            "(#{goods.userId},#{goods.goodsTitle},#{goods.categoryId},#{goods.goodsDetail},#{goods.goodsView},#{goods.goodsPrice})")
    @Options(useGeneratedKeys = true, keyProperty = "goodsId")
    void createGoods(@Param("goods") Goods goods);

    @Select("SELECT * FROM goods")
    @Results(id="GoodsMap", value = {
            @Result(property = "goodsImg", column = "goodsId", many = @Many(select = "com.example.lasttest.mapper.GoodsMapper.getGoodsImg")),
            @Result(property = "category", column = "categoryId", many = @Many(select = "com.example.lasttest.mapper.GoodsMapper.getCategory")),
            @Result(property = "user", column = "userId", many = @Many(select = "com.example.lasttest.mapper.UserMapper.getUserById"))
    })
    List<Goods> allGoods();

    @Select("SELECT * FROM goods WHERE goodsId=#{goodsId}")
    @ResultMap("GoodsMap")
    Goods getGoodsById(@Param("goodsId") int goodsId);

    @Select("SELECT * FROM goods WHERE userId=#{userId}")
    @ResultMap("GoodsMap")
    List<Goods> getGoodsByUserId(@Param("userId") int userId);

    @Select("SELECT count(goodsLikeId) FROM goodsLike WHERE status='TRUE' group by goodsId HAVING goodsId=#{goodsId}")
    int getGoodsLike(@Param("goodsId") int goodsId);

    @Select("SELECT * from goodsImg WHERE goodsId=#{goodsId}")
    List<GoodsImg> getGoodsImg(@Param("goodsId") int goodsId);

    @Select("SELECT * FROM category WHERE categoryId=#{categoryId}")
    Category getCategory(@Param("categoryId") int categoryId);
}
