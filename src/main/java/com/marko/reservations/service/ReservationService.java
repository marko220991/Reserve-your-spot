package com.marko.reservations.service;

import com.marko.reservations.exception.EntityNotFoundException;
import com.marko.reservations.model.Reservation;
import com.marko.reservations.model.User;
import com.marko.reservations.model.WorkStation;
import com.marko.reservations.repository.ReservationRepository;
import com.marko.reservations.repository.UserRepository;
import com.marko.reservations.repository.WorkStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final WorkStationRepository workStationRepository;

    @Autowired
    public ReservationService(ReservationRepository repository,
                              UserRepository userRepository,
                              WorkStationRepository workStationRepository) {
        this.reservationRepository = repository;
        this.userRepository = userRepository;
        this.workStationRepository = workStationRepository;
    }

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public Reservation findByDateAndUserId(LocalDate date, long id) {
        return reservationRepository.findByDateAndUserId(date, id);
    }

    public Reservation findByDateAndWorkStationId(LocalDate date, long id) {
        return reservationRepository.findByDateAndWorkStationId(date, id);
    }

    public List<Reservation> bookReservations(LocalDate dateFrom, LocalDate dateTo, long userId, long workStationId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<WorkStation> workStationOptional = workStationRepository.findById(workStationId);
        if (userOptional.isEmpty() || workStationOptional.isEmpty()) {
            throw new EntityNotFoundException("User or WorkStation entered does not exist in database!");
        }
        List<LocalDate> dates = getDateRange(dateFrom, dateTo);
        List<Reservation> reservations = new ArrayList<>();

        for (LocalDate date : dates) {
            reservations.add(new Reservation(date, workStationOptional.get(), userOptional.get()));
        }
        return reservationRepository.saveAll(reservations);
    }

    //method to create date range
    private static List<LocalDate> getDateRange(LocalDate start, LocalDate end) {
        List<LocalDate> ret = new ArrayList<LocalDate>();
        LocalDate tmp = start;
        while (tmp.isBefore(end) || tmp.equals(end)) {
            ret.add(tmp);
            tmp = tmp.plusDays(1);
        }
        return ret;
    }

}
