package com.marko.reservations.repository;

import com.marko.reservations.model.OfficeRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRoomRepository extends JpaRepository<OfficeRoom, Long> {
}
