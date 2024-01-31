package com.marko.reservations.repository;

import com.marko.reservations.model.OfficeSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeSpaceRepository extends JpaRepository<OfficeSpace, Long> {
}
