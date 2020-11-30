package ru.itsjava.project.rest.controller.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itsjava.project.model.User;

@Data
@AllArgsConstructor
public class UserDto {
    private long id;
    private String name;
    private int age;

    public static User toDomainObject(UserDto userDto) {
        return new User(userDto.id, userDto.name, userDto.age);
    }

    public static UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getAge());
    }
}
