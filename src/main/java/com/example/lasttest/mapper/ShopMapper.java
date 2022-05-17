package com.example.lasttest.mapper;

import com.example.lasttest.model.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShopMapper {

    @Insert("INSERT INTO shop(locationId, userId, shopProfileImgUrl, shopName, shopDetail)\n" +
            "        VALUES (#{shop.locationId}, #{shop.userId}, #{shop.shopProfileImgUrl}, #{shop.shopName}, #{shop.shopDetail})")
    @Options(useGeneratedKeys = true, keyProperty = "shopId")
    Shop createShop(@Param("shop") Shop shop);

    @Select("SELECT * FROM shop")
    @Results(id="ShopMap", value={
            @Result(property = "location", column = "locationId", many=@Many(select = "com.example.lasttest.mapper.LocationMapper.getLocationById")),
            @Result(property = "user", column = "userId", many=@Many(select = "com.example.lasttest.mapper.UserMapper.getUserById")),
            @Result(property = "shopImg", column = "shopId", many=@Many(select = "com.example.lasttest.mapper.ShopMapper.getShopImg")),
            @Result(property = "custom", column = "shopId", many=@Many(select = "com.example.lasttest.mapper.ShopMapper.countCustom")),
            @Result(property = "shopNews", column = "shopId", many=@Many(select = "com.example.lasttest.mapper.ShopMapper.getNewsByShopId"))
    })
    List<Shop> allShop();

    @Select("SELECT * FROM shop WHERE shopId=#{shopId}")
    @ResultMap("ShopMap")
    Shop getShopById(@Param("shopId") int shopId);

    @Select("SELECT * FROM shopImg WHERE shopId=#{shopId}")
    List<ShopImg> getShopImg(@Param("shopId") int shopId);

    @Select("SELECT count(customId) FROM custom WHERE status='TRUE' GROUP BY shopId HAVING shopId=#{shopId}")
    int countCustom(@Param("shopId") int shopId);

    @Select("SELECT * from review WHERE shopId=#{shopId}")
    @Results(id="ReviewMap", value = {
            @Result(property = "user", column = "userId", many = @Many(select = "com.example.lasttest.mapper.UserMapper.getUserById")),
            @Result(property = "reviewLike", column = "reviewId", many = @Many(select = "com.example.lasttest.mapper.ShopMapper.countReviewLike")),
            @Result(property = "reviewImg", column = "reviewId", many = @Many(select = "com.example.lasttest.mapper.ShopMapper.getReviewImg"))
    })
    List<Review> getReviewByShopId(@Param("shopId") int shopId);

    @Select("SELECT count(reviewId) FROM reviewLike WHERE status='TRUE' GROUP BY reviewId HAVING reviewId=#{reviewId}")
    int countReviewLike(@Param("reviewId") int reviewId);

    @Select("SELECT * FROM reviewImg WHERE reviewId=#{reviewId}")
    List<ReviewImg> getReviewImg(@Param("reviewId") int reviewId);

    @Select("SELECT * FROM shopNews")
    @Results(id="NewsImgMap", value = {
            @Result(property = "shopNewsImg", column = "shopNewsId", many=@Many(select = "com.example.lasttest.mapper.ShopMapper.getNewsImg"))
    })
    List<ShopNews> allNews();

    @Select("SELECT * FROM shopNews WHERE shopId = #{shopId}")
    @ResultMap("NewsImgMap")
    List<ShopNews> getNewsByShopId(@Param("shopId") int shopId);

    @Select("SELECT * FROM shopNewsImg WHERE shopNewsId = #{shopNewsId}")
    List<ShopNewsImg> getNewsImg(@Param("shopNewsId") int shopNewsId);
}
