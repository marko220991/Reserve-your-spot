package com.marko.reservations.controller;

import com.marko.reservations.model.Reservation;
import com.marko.reservations.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/users/{date}/{id}")
    public Reservation findByDateAndUserId(@PathVariable LocalDate date, @PathVariable long id) {
        return reservationService.findByDateAndUserId(date, id);
    }

    @GetMapping("/stations/{date}/{id}")
    public Reservation findByDateAndWorkStationId(@PathVariable LocalDate date, @PathVariable long id) {
        return reservationService.findByDateAndWorkStationId(date, id);
    }

    @PostMapping("/saveAll/{from}/{to}/{userId}/{stationId}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Reservation> saveReservationsByDateRange(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate from,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate to,
            @PathVariable("userId") long userId,
            @PathVariable("stationId") long workStationId) {
        return reservationService.bookReservations(from, to, userId, workStationId);
    }

    @GetMapping("/{from}/{to}")
    public List<Reservation> findAllByDateRange(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate from,
                                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate to) {
        return reservationService.findReservationsByDateRange(from, to);
    }

    @DeleteMapping("/delete/{date}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReservationByDate(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate date) {
        reservationService.deleteReservationByDate(date);
    }
}
