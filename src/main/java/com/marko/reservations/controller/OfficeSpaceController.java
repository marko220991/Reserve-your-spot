package com.marko.reservations.controller;

import com.marko.reservations.model.OfficeRoom;
import com.marko.reservations.model.OfficeSpace;
import com.marko.reservations.service.OfficeSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spaces")
public class OfficeSpaceController {

    private final OfficeSpaceService officeSpaceService;
    @Autowired
    public OfficeSpaceController(OfficeSpaceService officeSpaceService) {
        this.officeSpaceService = officeSpaceService;
    }
    @GetMapping("/")
    public List<OfficeSpace> findAll() {
        return officeSpaceService.getAll();
    }

    @PostMapping("/add")
    public OfficeSpace addSpace(@RequestBody OfficeSpace officeSpace) {
        return officeSpaceService.saveSpace(officeSpace);
    }
}
