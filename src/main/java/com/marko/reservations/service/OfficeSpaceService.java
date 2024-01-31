package com.marko.reservations.service;

import com.marko.reservations.repository.OfficeSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficeSpaceService {

    private OfficeSpaceRepository officeSpaceRepository;
    @Autowired
    public OfficeSpaceService(OfficeSpaceRepository officeSpaceRepository) {
        this.officeSpaceRepository = officeSpaceRepository;
    }
}
