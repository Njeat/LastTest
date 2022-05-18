package com.example.lasttest.mapper;

import com.example.lasttest.model.Chat;
import com.example.lasttest.model.Room;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoomMapper {

    @Insert("INSERT INTO room (goodsId, buyerId) VALUES" +
            "(#{room.goodsId}, #{room.buyerId})")
    @Options(useGeneratedKeys = true, keyProperty = "roomId")
    void createRoom(@Param("room") Room room);

    @Select("SELECT * FROM room")
    @Results(id = "RoomMap", value = {
            @Result(property = "buyer", column = "buyerId", many = @Many(select = "com.example.lasttest.mapper.UserMapper.getUserById")),
            @Result(property = "goods", column = "goodsId", many = @Many(select = "com.example.lasttest.mapper.GoodsMapper.getGoodsById")),
            @Result(property = "message", column = "roomId", many = @Many(select = "com.example.lasttest.mapper.RoomMapper.getMessage"))
    })
    List<Room> allRoom();

    @Select("SELECT * FROM room WHERE goodsId=#{goodsId}")
    @ResultMap("RoomMap")
    List<Room> getRoomByGoodsId(@Param("goodsId") int goodsId);

    @Select("SELECT * FROM chat WHERE roomId=#{roomId}")
    List<Chat> getMessage(@Param("roomId") int roomId);
}
