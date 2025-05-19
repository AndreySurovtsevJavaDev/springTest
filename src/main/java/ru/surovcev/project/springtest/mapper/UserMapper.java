package ru.surovcev.project.springtest.mapper;

import org.mapstruct.Mapper;
import ru.surovcev.project.springtest.data.UserResponseDto;
import ru.surovcev.project.springtest.model.User;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * Добавляем абстрактные методы в интерфейс, реализацию которых возьмет на себя MapStruct
     * @param user
     * @return
     */
    UserResponseDto toUserResponseDto(User user);    // Мапа юзера в Ответ

    List<UserResponseDto> toUserResponseDtoList(List<User> users);  // мапа списка пользователей в Ответ
}
