package com.marko.reservations.repository;

import com.marko.reservations.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT r FROM Reservation r JOIN r.user u WHERE u.id=:id and r.date=:date")
    public Reservation findByDateAndUserId(@Param("date") LocalDate date, @Param("id") long userId);
    @Query("SELECT r FROM Reservation r JOIN r.workStation w WHERE w.id=:id and r.date=:date")
    public Reservation findByDateAndWorkStationId(@Param("date") LocalDate date, @Param("id") long workStationId);
    @Query("SELECT r FROM Reservation r WHERE r.date BETWEEN :from and :to")
    public List<Reservation> findAllReservationByDateRange(@Param("from") LocalDate dateFrom, @Param("to") LocalDate dateTo);
}
