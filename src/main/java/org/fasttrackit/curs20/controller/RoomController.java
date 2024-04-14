package org.fasttrackit.curs20.controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.curs20.model.Room;
import org.fasttrackit.curs20.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("rooms")
@CrossOrigin(value = "http://localhost:4200")
public class RoomController {
    private final RoomService roomService;

    @GetMapping
    public List<org.fasttrackit.curs20.model.Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @DeleteMapping("{id}") //  http://localhost:8080/rooms/{id}
    public org.fasttrackit.curs20.model.Room deleteById(@PathVariable Long id) {
        return roomService.deleteById(id);
    }

    @PostMapping//   http://localhost:8080/rooms
    public Room addNewRoom(@RequestBody Room room) {
        return roomService.addNewRoom(room);
    }

    @PutMapping("{id}")
    public Room replaceRoom(@PathVariable Long id, @RequestBody Room room) {
        return roomService.updateRoom(id, room);
    }
}