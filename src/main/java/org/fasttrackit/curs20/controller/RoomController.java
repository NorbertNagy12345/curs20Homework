package org.fasttrackit.curs20.controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.curs20.exceptions.ResourceNotFoundException;
import org.fasttrackit.curs20.model.Room;
import org.fasttrackit.curs20.service.RoomService;
import org.fasttrackit.curs20.service.SensorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("rooms")
@CrossOrigin(value = "http://localhost:4200")
public class RoomController {
    private final RoomService roomService;
    private final SensorService sensorService;

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

    @PostMapping("/resetSensors")
    public void resetAllSensors() {
        sensorService.resetAllSensors();
    }

    @PutMapping("/{roomId}/smartLight")
    public ResponseEntity<Room> toggleSmartLight(@PathVariable Long roomId) {
        try {
            Room updatedRoom = roomService.toggleSmartLightState(roomId);
            return new ResponseEntity<>(roomService.updateRoom(roomId,updatedRoom), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}