package ru.itsjava.hibernate.services.repository;

import ru.itsjava.hibernate.services.model.Mail;

import java.util.Optional;

public interface MailRepository {
    Mail save(Mail film);
    Optional<Mail> getById(long id);
    void updateMail(Mail film);
    void deleteById(long id);
}
