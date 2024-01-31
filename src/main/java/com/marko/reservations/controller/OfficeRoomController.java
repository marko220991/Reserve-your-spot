package com.marko.reservations.controller;

import com.marko.reservations.service.OfficeRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfficeRoomController {

    private OfficeRoomService officeRoomService;
    @Autowired
    public OfficeRoomController(OfficeRoomService officeRoomService) {
        this.officeRoomService = officeRoomService;
    }
}
