package com.example.lasttest.controller;

import com.example.lasttest.model.Chat;
import com.example.lasttest.model.Room;
import com.example.lasttest.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @PostMapping("/room")
    public Room createRoom(@RequestBody Room room){
        roomService.createRoom(room);
        return room;
    }

    @GetMapping("/room")
    public List<Room> allRoom(){
        return roomService.allRoom();
    }

    @GetMapping("/room/{goodsId}")
    public List<Room> getRoomByGoodsId(@PathVariable("goodsId") int goodsId){
        return roomService.getRoomByGoodsId(goodsId);
    }

    @GetMapping("/room/message/{roomId}")
    public List<Chat> getMessage(@PathVariable("roomId") int roomId){
        return roomService.getMessage(roomId);
    }
}
