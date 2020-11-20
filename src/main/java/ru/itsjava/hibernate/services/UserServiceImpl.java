package ru.itsjava.hibernate.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.hibernate.model.User;
import ru.itsjava.hibernate.repository.UserRepository;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Transactional
    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public void printById(long id) {
        System.out.println(userRepository.getById(id));
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
