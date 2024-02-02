package com.marko.reservations.controller;

import com.marko.reservations.service.ReservationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ReservationController.class)
public class ReservationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReservationService reservationService;

    @DisplayName("JUnit test for getting all Reservations")
    @Test
    public void test_get_all_reservations() throws Exception {
        mockMvc.perform(get("/api/reservations"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("JUnit test for getting Reservation by given user id and date")
    @Test
    public void test_get_reservation_by_id_and_dateRange() throws Exception {
        mockMvc.perform(get("/api/reservations/users/2022-02-06/1"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("JUnit test for getting Reservations by given date range")
    @Test
    public void test_get_reservations_by_dateRange() throws Exception {
        mockMvc.perform(get("/api/reservations/2022-02-03/2022-02-05"))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
