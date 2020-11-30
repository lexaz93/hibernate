package ru.itsjava.hibernate.services.services;

import ru.itsjava.hibernate.services.model.Mail;

public interface MailService {
    void printById(long id);
    void updateMail(Mail mail, String email);
}
