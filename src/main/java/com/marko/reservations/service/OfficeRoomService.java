package com.marko.reservations.service;

import com.marko.reservations.exception.EntityNotFoundException;
import com.marko.reservations.model.OfficeRoom;
import com.marko.reservations.model.User;
import com.marko.reservations.repository.OfficeRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<OfficeRoom> getById(long id) {
        Optional<OfficeRoom> optionalOfficeRoom = officeRoomRepository.findById(id);
        if (optionalOfficeRoom.isEmpty()) {
            throw new EntityNotFoundException("Office Room with id " + id + " not found in database!");
        }
        return  optionalOfficeRoom;
    }
    public OfficeRoom saveRoom(OfficeRoom officeRoom) {
        return officeRoomRepository.save(officeRoom);
    }

    public void deleteOfficeRoom(long id) {
        Optional<OfficeRoom> optionalOfficeRoom = officeRoomRepository.findById(id);
        if (optionalOfficeRoom.isEmpty()) {
            throw new EntityNotFoundException("Office Room with id " + id + " not found in database!");
        }
        OfficeRoom officeRoom = optionalOfficeRoom.get();
        officeRoomRepository.delete(officeRoom);
    }
}
