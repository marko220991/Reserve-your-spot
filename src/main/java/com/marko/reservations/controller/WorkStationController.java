package com.marko.reservations.controller;

import com.marko.reservations.model.WorkStation;
import com.marko.reservations.service.WorkStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/stations")
public class WorkStationController {

    private final WorkStationService workStationService;

    @Autowired
    public WorkStationController(WorkStationService workStationService) {
        this.workStationService = workStationService;
    }

    @GetMapping
    public List<WorkStation> findAll() {
        return workStationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<WorkStation> findById(@PathVariable long id) {
        return workStationService.getById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public WorkStation saveWorkStation(@RequestBody WorkStation workStation) {
        return workStationService.addWorkStation(workStation);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWorkStation(@PathVariable long id) {
        workStationService.delete(id);
    }
}
