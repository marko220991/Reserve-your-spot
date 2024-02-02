package com.marko.reservations.controller;

import com.marko.reservations.model.OfficeRoom;
import com.marko.reservations.service.OfficeRoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/rooms")
public class OfficeRoomController {

    private final OfficeRoomService officeRoomService;

    @Autowired
    public OfficeRoomController(OfficeRoomService officeRoomService) {
        this.officeRoomService = officeRoomService;
    }

    @GetMapping
    public List<OfficeRoom> findAll() {
        return officeRoomService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<OfficeRoom> findById(@PathVariable long id) {
        return officeRoomService.getById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public OfficeRoom addRoom(@Valid @RequestBody OfficeRoom officeRoom) {
        return officeRoomService.saveRoom(officeRoom);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeOfficeRoom(@PathVariable long id) {
        officeRoomService.deleteOfficeRoom(id);
    }
}
