package ru.surovcev.project.springtest.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.surovcev.project.springtest.data.UserResponseDto;
import ru.surovcev.project.springtest.mapper.UserMapper;
import ru.surovcev.project.springtest.model.User;
import ru.surovcev.project.springtest.service.UserService;

import java.util.List;
import java.util.logging.Logger;

/**
 *
 */
@RestController
@RequestMapping("/api")
public class UserController {

    /**
     * 9.   Настройте логирование всех запросов в Spring Boot
     */
    private static Logger logger =
            Logger.getLogger(UserController.class.getName());

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    /**
     *
     * @return
     */
//    @GetMapping("/user-over-18")
//    public List<User> findUsersByAge() {
//        logger.info("Поиск пользователей старше 18");
//        return userService.findUsersOverAge(18);
//    }

    @GetMapping("/v2/user-over-18")
    public ResponseEntity<List<UserResponseDto>> findUsersByAge() {
        logger.info("Поиск пользователя старше 18 лет");
        List<User> users = userService.findUsersOverAge(18);
        List<UserResponseDto> userResponseDtoList = userMapper.toUserResponseDtoList(users);
        return ResponseEntity.ok(userResponseDtoList);
    }

    /**
     * 2.   Напишите сервисный класс UserServiceImpl с методом findUserById(Long id)
     * @param id
     * @return
     */
    @GetMapping("/user-by-id")
    public User findUserById(@RequestParam("id") long id) {
        logger.info("Поиск пользователя по id: " + id);
        return userService.findUserById(id);
    }


    /**
     * 3.   Создайте REST-эндпоинт POST /api/users, который принимает JSON и сохраняет пользователя.
     */
    @PostMapping("/user")
    public void createUser(@RequestBody User user) {
        logger.info("Создание пользователя " + user.toString());
        userService.createUser(user);
    }

    /**
     * 10.   Реализуйте метод, который обновляет данные пользователя по его ID.
     */
    @PutMapping("/user-by-id")
    public User updateUser(
            @RequestParam long id,
            @RequestBody User user) {
        logger.info("Обновление пользователя: " + user.toString());
        return userService.updateUser(id, user);
    }


    /**
     * 11.  Создайте REST-эндпоинт для удаления пользователя по ID.
     */
    @DeleteMapping("/user-by-id")
    public void deleteUserById(@RequestParam("id") long id) {

        logger.info("Удаление пользователя по id: " + id);
        userService.deleteUserById(id);
    }

    /**
     * 12.  Напишите метод, который возвращает пользователей с пагинацией (используя Pageable)
     */
    @GetMapping("/user-all")
    public Page<User> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            Pageable pageable) {
        logger.info("Поиск всех пользователей с пагинацией: " + page + " " + size);
        Pageable paging = PageRequest.of(page, size);
        return userService.findAllUsers(paging);
    }

}
