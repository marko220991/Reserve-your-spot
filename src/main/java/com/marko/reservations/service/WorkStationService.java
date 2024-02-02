package com.marko.reservations.service;

import com.marko.reservations.exception.EntityNotFoundException;
import com.marko.reservations.model.WorkStation;
import com.marko.reservations.repository.WorkStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkStationService {

    private final WorkStationRepository workStationRepository;

    @Autowired
    public WorkStationService(WorkStationRepository workStationRepository) {
        this.workStationRepository = workStationRepository;
    }

    public List<WorkStation> getAll() {
        return workStationRepository.findAll();
    }

    public Optional<WorkStation> getById(long id) {
        Optional<WorkStation> optionalWorkStation = workStationRepository.findById(id);
        if (optionalWorkStation.isEmpty()) {
            throw new EntityNotFoundException("WorkStation with id " + id + " not found in database!");
        }
        return optionalWorkStation;
    }

    public WorkStation addWorkStation(WorkStation workStation) {
        return workStationRepository.save(workStation);
    }

    public void delete(long id) {
        Optional<WorkStation> optionalWorkStation = workStationRepository.findById(id);
        if (optionalWorkStation.isEmpty()) {
            throw new EntityNotFoundException("WorkStation with id " + id + " not found in database!");
        }

        WorkStation workStation = optionalWorkStation.get();
        workStationRepository.delete(workStation);
    }
}
