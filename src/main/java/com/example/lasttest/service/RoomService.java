package com.example.lasttest.service;

import com.example.lasttest.mapper.RoomMapper;
import com.example.lasttest.model.Chat;
import com.example.lasttest.model.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Getter
@Slf4j
public class RoomService {
    private final RoomMapper roomMapper;

    public void createRoom(Room room){
        roomMapper.createRoom(room);
    }

    public List<Room> allRoom(){
        return roomMapper.allRoom();
    }

    public List<Room> getRoomByGoodsId(int goodsId){
        return roomMapper.getRoomByGoodsId(goodsId);
    }

    public List<Chat> getMessage(int roomId){
        return roomMapper.getMessage(roomId);
    }
}
