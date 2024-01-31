package com.marko.reservations.service;

import com.marko.reservations.model.OfficeRoom;
import com.marko.reservations.model.OfficeSpace;
import com.marko.reservations.repository.OfficeSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public OfficeSpace saveSpace(OfficeSpace officeSpace) {
        return officeSpaceRepository.save(officeSpace);
    }
}
