package com.ast.hospitalmanagement.service;

import com.ast.hospitalmanagement.dtos.request.AddRoomRequestDto;
import com.ast.hospitalmanagement.entity.Room;
import com.ast.hospitalmanagement.enums.RoomStatus;
import com.ast.hospitalmanagement.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room addRoom(AddRoomRequestDto addRoomRequestDto) {
        Room room = Room.builder()
                .roomNo(addRoomRequestDto.getRoomNo())
                .status(RoomStatus.AVAILABLE.getRoomStatus())
                .build();
        return roomRepository.save(room);
    }

    public List<Room> getAllAvailableRooms() {
        return roomRepository.getAvailableRooms(RoomStatus.AVAILABLE.getRoomStatus());
    }

    public Room getById(Integer id) {
        return roomRepository.findById(id).get();
    }
}

