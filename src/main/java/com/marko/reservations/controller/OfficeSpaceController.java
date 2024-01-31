package com.marko.reservations.controller;

import com.marko.reservations.service.OfficeSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfficeSpaceController {

    private OfficeSpaceService officeSpaceService;
    @Autowired
    public OfficeSpaceController(OfficeSpaceService officeSpaceService) {
        this.officeSpaceService = officeSpaceService;
    }
}
