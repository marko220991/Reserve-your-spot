package com.marko.reservations.controller;

import com.marko.reservations.model.Reservation;
import com.marko.reservations.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @GetMapping
    public List<Reservation> findAll() {
        return reservationService.getAll();
    }
    @GetMapping("users/{date}/{id}")
    public Reservation findByDateAndUserId(@PathVariable LocalDate date, @PathVariable long id) {
        return reservationService.findByDateAndUserId(date, id);
    }
    @GetMapping("stations/{date}/{id}")
    public Reservation findByDateAndWorkStationId(@PathVariable LocalDate date, @PathVariable long id) {
        return reservationService.findByDateAndWorkStationId(date, id);
    }
}
