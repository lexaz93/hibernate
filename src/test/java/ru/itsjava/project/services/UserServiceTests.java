package ru.itsjava.project.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.project.model.Mail;
import ru.itsjava.project.model.Pet;
import ru.itsjava.project.model.User;
import ru.itsjava.project.repository.UserRepositoryImpl;
import ru.itsjava.project.services.UserService;
import ru.itsjava.project.services.UserServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserService have:")
@Import({UserServiceImpl.class, UserRepositoryImpl.class})
@DataJpaTest
class UserServiceTests {
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    UserService userService;

    @DisplayName("correct method findById();")
    @Test
    public void sholdCorrectFindById() {
        Mail mail = new Mail(0l, "alex@mail.ru");
        Pet pet = new Pet(0l,"Cat", "Musya");
        User user = new User(0l, "Alex", 27, mail, pet);
        entityManager.persist(user);

        assertNotEquals(0L, user.getId());
        assertEquals(Optional.of(user), userService.findById(user.getId()));
    }

    @DisplayName("correct method save();")
    @Test
    public void sholdCorrectSave() {
        Mail mail = new Mail(0l, "alex@mail.ru");
        Pet pet = new Pet(0l,"Cat", "Musya");
        User user = new User(0l, "Alex", 27, mail, pet);
        userService.save(user);

        assertEquals(Optional.of(user), userService.findById(user.getId()));
    }

    @DisplayName("correct method updateUser();")
    @Test
    public void sholdCorrectUpdateUser() {
        Mail mail = new Mail(0l, "alex@mail.ru");
        Pet pet = new Pet(0l,"Cat", "Musya");
        User user = new User(0l, "Alex", 27, mail, pet);
        userService.save(user);
        userService.updateUser(user, 30);
        user.setAge(30);

        assertEquals(Optional.of(user), userService.findById(user.getId()));
    }

    @DisplayName("correct method delete();")
    @Test
    public void sholdCorrectDeleteById() {
        Mail mail = new Mail(0l, "alex@mail.ru");
        Pet pet = new Pet(0l,"Cat", "Musya");
        User user = new User(0l, "Alex", 27, mail, pet);
        userService.save(user);
        userService.deleteUser(user);

        assertEquals(Optional.empty(), userService.findById(user.getId()));
    }
}
