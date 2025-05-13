package ru.surovcev.project.springtest.service;

import org.springframework.stereotype.Service;
import ru.surovcev.project.springtest.model.User;
import ru.surovcev.project.springtest.repository.UserRepository;

import java.util.List;

/**
 * 2.   Напишите сервисный класс UserService с методом findUserById(Long id)
 * для этого создадим класс-модель User, класс-репозиторий и для теста будем работать с H2 в роли БД (это заодно и другие задачки зацепит)
 */
@Service
public class UserService {
//    private final User user;
//    public UserService(User user) {this.user = user;}

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(long id) {
        return userRepository.findById(id);
    }

    /**
     * 6.  Реализуйте метод в сервисе, который возвращает всех пользователей старше 18 лет
     * @param age
     * @return
     */
    public List<User> findUsersOverAge(int age) {
        return userRepository.findUsersOverAge(18);
    }

}
