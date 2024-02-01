package com.marko.reservations.service;

import com.marko.reservations.model.Reservation;
import com.marko.reservations.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    @Autowired
    public ReservationService(ReservationRepository repository) {
        this.reservationRepository = repository;
    }

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }
}
