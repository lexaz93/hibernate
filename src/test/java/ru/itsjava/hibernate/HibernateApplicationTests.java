package ru.itsjava.hibernate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.hibernate.model.Mail;
import ru.itsjava.hibernate.model.Pet;
import ru.itsjava.hibernate.model.User;
import ru.itsjava.hibernate.repository.UserRepository;
import ru.itsjava.hibernate.repository.UserRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserRepository have:")
@Import(UserRepositoryImpl.class)
@DataJpaTest
class HibernateApplicationTests {
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    UserRepository userRepository;

    @DisplayName("correct method getById();")
    @Test
    public void sholdCorrectFindById() {
        Mail mail = new Mail(0l, "alex@mail.ru");
        Pet pet = new Pet(0l,"Cat", "Musya");
        User user = new User(0l, "Alex", 27, mail, pet);
        entityManager.persist(user);

        assertNotEquals(0L, user.getId());
        assertEquals(Optional.of(user), userRepository.getById(user.getId()));
    }

    @DisplayName("correct method save();")
    @Test
    public void sholdCorrectSave() {
        Mail mail = new Mail(0l, "alex@mail.ru");
        Pet pet = new Pet(0l,"Cat", "Musya");
        User user = new User(0l, "Alex", 27, mail, pet);
        userRepository.save(user);

        assertEquals(Optional.of(user), userRepository.getById(user.getId()));
    }

    @DisplayName("correct method updateUser();")
    @Test
    public void sholdCorrectUpdateUser() {
        Mail mail = new Mail(0l, "alex@mail.ru");
        Pet pet = new Pet(0l,"Cat", "Musya");
        User user = new User(0l, "Alex", 27, mail, pet);
        userRepository.save(user);
        user.setAge(30);
        userRepository.updateUser(user);

        assertEquals(Optional.of(user), userRepository.getById(user.getId()));
    }

    @DisplayName("correct method deleteById();")
    @Test
    public void sholdCorrectDeleteById() {
        Mail mail = new Mail(0l, "alex@mail.ru");
        Pet pet = new Pet(0l,"Cat", "Musya");
        User user = new User(0l, "Alex", 27, mail, pet);
        userRepository.save(user);
        userRepository.deleteById(user.getId());

        assertEquals(Optional.empty(), userRepository.getById(user.getId()));
    }
}
