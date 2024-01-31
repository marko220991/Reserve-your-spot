package com.marko.reservations.service;

import com.marko.reservations.model.OfficeRoom;
import com.marko.reservations.repository.OfficeRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeRoomService {

    private final OfficeRoomRepository officeRoomRepository;
    @Autowired
    public OfficeRoomService(OfficeRoomRepository officeRoomRepository) {
        this.officeRoomRepository = officeRoomRepository;
    }

    public List<OfficeRoom> getAll() {
        return officeRoomRepository.findAll();
    }

    public OfficeRoom saveRoom(OfficeRoom officeRoom) {
        return officeRoomRepository.save(officeRoom);
    }
}
