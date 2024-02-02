package com.marko.reservations.controller;

import com.marko.reservations.model.WorkStation;
import com.marko.reservations.service.WorkStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
