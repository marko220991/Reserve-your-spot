package com.marko.reservations.controller;

import com.marko.reservations.model.User;
import com.marko.reservations.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private User user1;
    private User user2;

    @BeforeEach
    public void setup(){
        user1 = new User(1L, "Marko", "19marko91.ilic@gmail.com");
        user2 = new User(2L, "Milos", "milosNole@gmail.com");
    }

    @DisplayName("JUnit test for getting all Users")
    @Test
    public void test_get_all_users() throws Exception {
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andDo(print());
    }
    @DisplayName("JUnit test for getting User by given ID")
    @Test
    public void test_get_user_by_id() throws Exception {
        mockMvc.perform(get("/api/users/{id}", 1))
                .andExpect(status().isOk())
                .andDo(print());
    }
    @DisplayName("JUnit test for deleting User by given ID")
    @Test
    public void test_delete_user_by_id() throws Exception {
        mockMvc.perform(delete("/api/users/delete/{id}", 1))
                .andExpect(status().isNoContent())
                .andDo(print());
    }
}
