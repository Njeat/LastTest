package com.example.lasttest.mapper;

import com.example.lasttest.model.Shop;
import com.example.lasttest.model.ShopImg;
import com.example.lasttest.model.User;
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
            @Result(property = "custom", column = "shopId", many=@Many(select = "com.example.lasttest.mapper.ShopMapper.countCustom"))
    })
    List<Shop> allShop();

    @Select("SELECT * FROM shop WHERE shopId=#{shopId}")
    @ResultMap("ShopMap")
    Shop getShopById(@Param("shopId") int shopId);

    @Select("SELECT * FROM shopImg WHERE shopId=#{shopId}")
    List<ShopImg> getShopImg(@Param("shopId") int shopId);

    @Select("SELECT count(customId) FROM custom WHERE status='TRUE' GROUP BY shopId HAVING shopId=#{shopId}")
    int countCustom(@Param("shopId") int shopId);


}
