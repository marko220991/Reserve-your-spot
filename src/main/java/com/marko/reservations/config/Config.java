package com.marko.reservations.config;

import com.marko.reservations.model.OfficeRoom;
import com.marko.reservations.model.OfficeSpace;
import com.marko.reservations.model.User;
import com.marko.reservations.model.WorkStation;
import com.marko.reservations.repository.OfficeRoomRepository;
import com.marko.reservations.repository.OfficeSpaceRepository;
import com.marko.reservations.repository.UserRepository;
import com.marko.reservations.repository.WorkStationRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Config {

    private final UserRepository userRepository;
    private final OfficeSpaceRepository officeSpaceRepository;
    private final OfficeRoomRepository officeRoomRepository;
    private final WorkStationRepository workStationRepository;

    @Autowired
    public Config(UserRepository userRepository,
                  OfficeSpaceRepository officeSpaceRepository,
                  OfficeRoomRepository officeRoomRepository,
                  WorkStationRepository workStationRepository) {
        this.userRepository = userRepository;
        this.officeSpaceRepository = officeSpaceRepository;
        this.officeRoomRepository = officeRoomRepository;
        this.workStationRepository = workStationRepository;
    }

    @PostConstruct
    public void startUpInit() {
        User userOne = new User(1L, "Marko2209", "19marko91.ilic@gmail.com");
        User userTwo = new User(2L, "Milos89", "dinra@gmail.com");
        User userThree = new User(3L, "Igor887", "alright@gmail.com");

        userRepository.save(userOne);
        userRepository.save(userTwo);
        userRepository.save(userThree);

        OfficeSpace officeSpaceOne = new OfficeSpace(1L, "PRODYNA AG", "Belgrade");
        OfficeSpace officeSpaceTwo = new OfficeSpace(2L, "QNIT AG", "Belgrade");
        officeSpaceRepository.save(officeSpaceOne);
        officeSpaceRepository.save(officeSpaceTwo);

        OfficeRoom officeRoomOne = new OfficeRoom(1L, "JAVA", "This is Java room", officeSpaceOne);
        OfficeRoom officeRoomTwo = new OfficeRoom(2L, ".NET", "This is .NET room", officeSpaceOne);
        officeRoomRepository.save(officeRoomOne);
        officeRoomRepository.save(officeRoomTwo);

        WorkStation workStationOne = new WorkStation(1L, "2209", "Work Station No1", officeRoomOne);
        WorkStation workStationTwo = new WorkStation(2L, "2210", "Work Station No2", officeRoomOne);
        workStationRepository.save(workStationOne);
        workStationRepository.save(workStationTwo);

    }
}
