package com.ast.hospitalmanagement.controller;

import com.ast.hospitalmanagement.dtos.request.AddRoomRequestDto;
import com.ast.hospitalmanagement.entity.Room;
import com.ast.hospitalmanagement.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/add")
    public ResponseEntity<Room> addRoom(@RequestBody @Valid AddRoomRequestDto addRoomRequestDto) {
        Room room = roomService.addRoom(addRoomRequestDto);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @GetMapping("/get-all-available")
    public ResponseEntity<List<Room>> getAllAvailableRooms() {
        List<Room> rooms = roomService.getAllAvailableRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/get-by-id")
    public ResponseEntity<Room> getAllAvailableRooms(@Param("room_id") Integer roomId) {
        Room room = roomService.getById(roomId);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }
}
