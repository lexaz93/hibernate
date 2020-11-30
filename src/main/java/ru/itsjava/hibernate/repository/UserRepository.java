package ru.itsjava.hibernate.repository;

import ru.itsjava.hibernate.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getAll();
    User save(User film);
    Optional<User> getById(long id);
    void updateUser(User film);
    void deleteById(long id);
}

