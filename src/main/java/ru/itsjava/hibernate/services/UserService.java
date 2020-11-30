package ru.itsjava.hibernate.services;

import ru.itsjava.hibernate.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void save(User user);
    void createUser(User user);
    User findById(long id);
    void updateUser(User user, int age);
    void deleteUser(User user);
}
