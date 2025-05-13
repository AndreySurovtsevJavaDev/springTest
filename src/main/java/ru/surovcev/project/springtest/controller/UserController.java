package ru.surovcev.project.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.surovcev.project.springtest.model.User;
import ru.surovcev.project.springtest.repository.UserRepository;
import ru.surovcev.project.springtest.service.UserService;

import java.util.List;

/**
 * 9.   Реализуйте метод, который обновляет данные пользователя по его ID.
 * 10   Создайте REST-эндпоинт для удаления пользователя по ID.
 *
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user-over-18")
    public List<User> findUsersByAge() {
        return userService.findUsersOverAge(18);
    }

    /**
     * 2.   Напишите сервисный класс UserService с методом findUserById(Long id)
     * @param id
     * @return
     */
    @GetMapping("/user-by-id")
    public User findUserById(@RequestParam("id") long id) {
        return userService.findUserById(id);
    }

    /**
     * 3.   Создайте REST-эндпоинт POST /api/users, который принимает JSON и сохраняет пользователя.
     */

//    @PostMapping("/user")
//    public void createUser(@RequestBody User user) {
//        userRepository.saveUser(user);
//    }

}
