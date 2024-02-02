package com.marko.reservations.controller;

import com.marko.reservations.model.WorkStation;
import com.marko.reservations.repository.WorkStationRepository;
import com.marko.reservations.service.WorkStationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WorkStationControllerTest {

    @Autowired
    private WorkStationService workStationService;
    @MockBean
    private WorkStationRepository workStationRepository;

    private WorkStation workStation;

    @BeforeEach
    public void setup(){
        workStation = new WorkStation(1l, "2233", "This is a test");
    }
    @DisplayName("Integration tests to find workStation by id")
    @Test
    public void test_find_station_by_id() {
        Optional<WorkStation> workStationOptional = Optional.of(workStation);
        when(workStationRepository.findById(1L)).thenReturn(workStationOptional);

        assertTrue(workStationService.getById(1L).get().getUniqueCode().contains("2233"));
    }
}
