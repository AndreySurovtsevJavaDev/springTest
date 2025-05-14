package ru.surovcev.project.springtest.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.surovcev.project.springtest.model.User;
import ru.surovcev.project.springtest.repository.UserRepository;

/**
 * 7.   Напишите тест для REST-контроллера с использованием MockMvc.
 * конфигурация: https://docs.spring.io/spring-framework/reference/testing/mockmvc/hamcrest/setup.html
 */

@ExtendWith(MockitoExtension.class)
public class UserControllerUnitTest {

    MockMvc mockMvc;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void creteUserSuccessFlow(){
        User user = new User();
        user.setId(1);
        user.setName("test");
        user.setAge(22);
    }

}
