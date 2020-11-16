package ru.itsjava.hibernate.repository;

import ru.itsjava.hibernate.model.Mail;

import java.util.Optional;

public interface MailRepository {
    Mail save(Mail film);
    Optional<Mail> getById(long id);
    void updateMail(Mail film);
    void deleteById(long id);
}
