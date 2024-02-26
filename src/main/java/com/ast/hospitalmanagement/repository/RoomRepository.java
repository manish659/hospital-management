package com.ast.hospitalmanagement.repository;

import com.ast.hospitalmanagement.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Query("SELECT r FROM Room r WHERE r.status = :status")
    List<Room> getAvailableRooms(@Param("status") String status);

    @Modifying
    @Transactional
    @Query("UPDATE Room r SET r.status = :status where r.id=:id")
    void updateStatusByRoomId(@Param("id") Integer room_id, @Param("status") String status);
}
