package ru.surovcev.project.springtest.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.surovcev.project.springtest.model.User;

import java.util.List;

/**
 * 5.   Создайте репозиторий для работы с сущностью User (используя Spring Data JPA)
 * 11.  Напишите метод, который возвращает пользователей с пагинацией (используя Pageable).
 * 12.  Напишите метод, который возвращает пользователей с пагинацией (используя Pageable).
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * 2.   Напишите сервисный класс UserService с методом findUserById(Long id)
     */
    User findById(long id);

    /**
     * 6.  Реализуйте метод в сервисе, который возвращает всех пользователей старше 18 лет
     * @param age
     * @return
     */
    @Query(value = "SELECT * FROM users WHERE age >= :age", nativeQuery = true)
    List<User> findUsersOverAge(int age);

}
