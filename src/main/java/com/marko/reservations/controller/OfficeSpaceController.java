package com.marko.reservations.controller;

import com.marko.reservations.model.OfficeSpace;
import com.marko.reservations.service.OfficeSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/spaces")
public class OfficeSpaceController {

    private final OfficeSpaceService officeSpaceService;

    @Autowired
    public OfficeSpaceController(OfficeSpaceService officeSpaceService) {
        this.officeSpaceService = officeSpaceService;
    }

    @GetMapping
    public List<OfficeSpace> findAll() {
        return officeSpaceService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<OfficeSpace> findById(@PathVariable long id) {
        return officeSpaceService.getById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public OfficeSpace addSpace(@RequestBody OfficeSpace officeSpace) {
        return officeSpaceService.saveSpace(officeSpace);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeOfficeSpace(@PathVariable long id) {
        officeSpaceService.deleteOfficeSpace(id);
    }
}
