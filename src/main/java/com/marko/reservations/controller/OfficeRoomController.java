package com.marko.reservations.controller;

import com.marko.reservations.model.OfficeRoom;
import com.marko.reservations.service.OfficeRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("rooms")
public class OfficeRoomController {

    private final OfficeRoomService officeRoomService;
    @Autowired
    public OfficeRoomController(OfficeRoomService officeRoomService) {
        this.officeRoomService = officeRoomService;
    }
    @GetMapping("/")
    public List<OfficeRoom> findAll() {
        return officeRoomService.getAll();
    }
    @GetMapping(params = "id")
    public Optional<OfficeRoom> findById(@RequestParam("id") long id) {
        return officeRoomService.getById(id);
    }
    @PostMapping("/add")
    public OfficeRoom addRoom(@RequestBody OfficeRoom officeRoom) {
        return officeRoomService.saveRoom(officeRoom);
    }
    @DeleteMapping(value = "/delete", params = "id")
    public void removeOfficeRoom(@RequestParam("id") long id) {
        officeRoomService.deleteOfficeRoom(id);
    }
}
