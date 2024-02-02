package com.marko.reservations.service;

import com.marko.reservations.exception.EntityNotFoundException;
import com.marko.reservations.model.OfficeRoom;
import com.marko.reservations.model.OfficeSpace;
import com.marko.reservations.repository.OfficeSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfficeSpaceService {

    private final OfficeSpaceRepository officeSpaceRepository;

    @Autowired
    public OfficeSpaceService(OfficeSpaceRepository officeSpaceRepository) {
        this.officeSpaceRepository = officeSpaceRepository;
    }

    public List<OfficeSpace> getAll() {
        return officeSpaceRepository.findAll();
    }

    public Optional<OfficeSpace> getById(long id) {
        Optional<OfficeSpace> optionalOfficeSpace = officeSpaceRepository.findById(id);
        if (optionalOfficeSpace.isEmpty()) {
            throw new EntityNotFoundException("Office Space with id " + id + " not found in database!");
        }
        return optionalOfficeSpace;
    }

    public OfficeSpace saveSpace(OfficeSpace officeSpace) {
        return officeSpaceRepository.save(officeSpace);
    }

    public void deleteOfficeSpace(long id) {
        Optional<OfficeSpace> optionalOfficeSpace = officeSpaceRepository.findById(id);
        if (optionalOfficeSpace.isEmpty()) {
            throw new EntityNotFoundException("Office Space with id " + id + " not found in database!");
        }
        OfficeSpace officeSpace = optionalOfficeSpace.get();
        officeSpaceRepository.delete(officeSpace);
    }
}
