package ru.surovcev.project.springtest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.surovcev.project.springtest.exception.UserNotFoundException;
import ru.surovcev.project.springtest.model.User;
import ru.surovcev.project.springtest.repository.UserRepository;

import java.util.List;

/**
 * 2.   Напишите сервисный класс UserServiceImpl с методом findUserById(Long id)
 * для этого создадим класс-модель User, класс-репозиторий и для теста будем работать с H2 в роли БД (это заодно и другие задачки зацепит)
 */
@Service
public class UserService {
    /**
     * Здесь я спецом не использую @Autowired а делаю DI через конструктор
     * Насколько я понял - данный метод более предпочтительный
     */
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(long id) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new UserNotFoundException("Пользователь с таким ID " + id + " не найден");
        }
        return user;
    }

    /**
     * 3.   Создайте REST-эндпоинт POST /api/users, который принимает JSON и сохраняет пользователя.
     */
    public void createUser(User user) {
        userRepository.save(user);
    }

    /**
     * 6.  Реализуйте метод в сервисе, который возвращает всех пользователей старше 18 лет
     * @param age
     * @return
     */
    public List<User> findUsersOverAge(int age) {
        return userRepository.findUsersOverAge(18);
    }

    /**
     * 10.   Реализуйте метод, который обновляет данные пользователя по его ID.
     */
    public User updateUser(long id,
                           User user){
        User updateUser = userRepository.findById(id);
        if (updateUser == null) {
            throw new UserNotFoundException("Пользователь с таким ID " + id + " не найден");
        }
        updateUser.setName(user.getName());
        updateUser.setAge(user.getAge());

        return  userRepository.save(user); // автообновление
    }

    /**
     * 11.  Создайте REST-эндпоинт для удаления пользователя по ID.
     */
    public void deleteUserById(long id) {
        User deleteUser = userRepository.findById(id);
        if (deleteUser == null) {
            throw new UserNotFoundException("Пользователь с таким ID " + id + " не найден");
        }
        userRepository.deleteById(id);
    }

    /**
     * 12. Напишите метод, который возвращает пользователей с пагинацией (используя Pageable)
     */
    public Page<User> findAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    };

}
