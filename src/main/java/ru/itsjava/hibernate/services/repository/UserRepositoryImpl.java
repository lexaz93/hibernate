package ru.itsjava.hibernate.services.repository;

import org.springframework.stereotype.Repository;
import ru.itsjava.hibernate.services.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        TypedQuery<User> query = entityManager.createQuery("select u " +
                "from User u", User.class);
        return query.getResultList();
    }

    @Override
    public User save(User user) {
        if (user.getId() == 0L) {
            entityManager.persist(user);
            return user;
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
