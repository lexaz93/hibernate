package ru.itsjava.project.rest.controller.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itsjava.project.model.Mail;
import ru.itsjava.project.model.Pet;
import ru.itsjava.project.model.User;

@Data
@AllArgsConstructor
public class UserDto {
    private long id;
    private String name;
    private int age;
    private String mail;
    private String typePet;
    private String pet;

    public static User toDomainObject(UserDto userDto) {
        return new User(userDto.id, userDto.name, userDto.age, new Mail(userDto.id, userDto.mail), new Pet(userDto.id, userDto.typePet, userDto.pet));
    }

    public static UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getAge(), user.getEmail().getEmail(), user.getPet().getTypePet(), user.getPet().getPetName());
    }
}
