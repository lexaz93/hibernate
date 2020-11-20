package ru.itsjava.hibernate.repository;

import org.springframework.stereotype.Repository;
import ru.itsjava.hibernate.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User save(User user) {
        if (user.getId() == 0L) {
            entityManager.persist(user);
            return  user;
        }
        return entityManager.merge(user);
    }

    @Override
    public Optional<User> getById(long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    @Override
    public void updateUser(User film) {
        entityManager.merge(film);
    }

    @Override
    public void deleteById(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
