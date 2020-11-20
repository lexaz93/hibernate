package ru.itsjava.hibernate.services;

import ru.itsjava.hibernate.model.User;

public interface UserService {
    void createUser(User user);
    void printById(long id);
    void updateUser(User user, int age);
    void deleteUser(User user);
}
