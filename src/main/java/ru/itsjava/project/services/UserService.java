package ru.itsjava.project.services;

import ru.itsjava.project.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    void save(User user);
    void createUser(User user);
    Optional<User> findById(long id);
    void updateUser(User user, int age);
    void deleteUser(User user);
}
