package ru.surovcev.project.springtest.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.surovcev.project.springtest.model.User;

import java.util.List;

/**
 * 5.   Создайте репозиторий для работы с сущностью User (используя Spring Data JPA)
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    /**
     * 2.   Напишите сервисный класс UserServiceImpl с методом findUserById(Long id)
     */
    User findById(long id);

    /**
     * 3.   Создайте REST-эндпоинт POST /api/users, который принимает JSON и сохраняет пользователя.
     * 10.   Использую и для обновления
     */
    User save(User user);

    /**
     * 6.  Реализуйте метод в сервисе, который возвращает всех пользователей старше 18 лет
     * @param age
     * @return
     */
    @Query(value = "SELECT * FROM users WHERE age >= :age", nativeQuery = true)
    List<User> findUsersOverAge(int age);

    /**
     * 11.  Создайте REST-эндпоинт для удаления пользователя по ID.
     */
    User deleteById(long id);
}
