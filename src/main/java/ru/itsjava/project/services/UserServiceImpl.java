package ru.itsjava.project.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.project.repository.UserRepository;
import ru.itsjava.project.model.User;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return userRepository.getAll();
    }

    @Transactional
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> findById(long id) {
        return userRepository.getById(id);
    }

    @Transactional
    @Override
    public void updateUser(User user, int age) {
        user.setAge(age);
        userRepository.updateUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(User user) {
        userRepository.deleteById(user.getId());
    }
}
