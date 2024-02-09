package com.marko.reservations.config;

import com.marko.reservations.model.*;
import com.marko.reservations.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Config {

    private final UserRepository userRepository;
    private final OfficeSpaceRepository officeSpaceRepository;
    private final OfficeRoomRepository officeRoomRepository;
    private final WorkStationRepository workStationRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public Config(UserRepository userRepository,
                  OfficeSpaceRepository officeSpaceRepository,
                  OfficeRoomRepository officeRoomRepository,
                  WorkStationRepository workStationRepository,
                  ReservationRepository reservationRepository) {
        this.userRepository = userRepository;
        this.officeSpaceRepository = officeSpaceRepository;
        this.officeRoomRepository = officeRoomRepository;
        this.workStationRepository = workStationRepository;
        this.reservationRepository = reservationRepository;
    }

    @PostConstruct
    public void startUpInit() {
        User userOne = new User(1L, "Marko2209", "19marko91.ilic@gmail.com");
        User userTwo = new User(2L, "Milos89", "dinra@gmail.com");
        User userThree = new User(3L, "Igor887", "alright@gmail.com");

        OfficeSpace officeSpaceOne = new OfficeSpace(1L, "PRODYNA AG", "Belgrade");
        OfficeSpace officeSpaceTwo = new OfficeSpace(2L, "QNIT AG", "Belgrade");

        OfficeRoom officeRoomOne = new OfficeRoom(1L, "JAVA", "This is Java room", officeSpaceOne);
        OfficeRoom officeRoomTwo = new OfficeRoom(2L, ".NET", "This is .NET room", officeSpaceOne);

        WorkStation workStationOne = new WorkStation(1L, "2209", "Work Station No1", officeRoomOne);
        WorkStation workStationTwo = new WorkStation(2L, "2210", "Work Station No2", officeRoomOne);

        LocalDate date = LocalDate.parse("2025-09-20");
        Reservation reservationOne = new Reservation(1L, date, workStationOne, userOne);


        userRepository.save(userOne);
        userRepository.save(userTwo);
        userRepository.save(userThree);
        officeSpaceRepository.save(officeSpaceOne);
        officeSpaceRepository.save(officeSpaceTwo);
        officeRoomRepository.save(officeRoomOne);
        officeRoomRepository.save(officeRoomTwo);
        workStationRepository.save(workStationOne);
        workStationRepository.save(workStationTwo);
        reservationRepository.save(reservationOne);

    }
}
