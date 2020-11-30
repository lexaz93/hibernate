package ru.itsjava.project.rest.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.web.servlet.MockMvc;
import ru.itsjava.project.services.repository.UserRepository;
import ru.itsjava.project.services.rest.controller.UserController;
import ru.itsjava.project.services.services.UserService;
import ru.itsjava.project.services.services.UserServiceImpl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("UserController have:")
@WebMvcTest(UserController.class)
public class UserControllerTests {
    @Configuration
    static class TestConfiguration {
        @MockBean
        private UserRepository userRepository;

        @Bean
        public UserService userService() {
            return new UserServiceImpl(userRepository);
        }

        @Bean
        public UserController userController() {
            return new UserController(userService());
        }
    }

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Autowired
    private UserController userController;

    @DisplayName("correct method getUserList().")
    @Test
    public void shouldCorrectMethodGetUserList() throws Exception {
        this.mockMvc.perform(get("/")).andExpect(status().isOk());
    }
}
