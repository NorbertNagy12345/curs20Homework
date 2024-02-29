package org.fasttrackit.curs20.controller;

import lombok.RequiredArgsConstructor;

import org.fasttrackit.curs20.model.Room;
import org.fasttrackit.curs20.service.RoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("rooms")
public class RoomController {
    private final RoomService roomService;

    @GetMapping
    public List<Room> getAll(Room room){
        return roomService.getAllRooms();
    }
}
