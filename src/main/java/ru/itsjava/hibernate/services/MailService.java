package ru.itsjava.hibernate.services;

import ru.itsjava.hibernate.model.Mail;

public interface MailService {
    void printById(long id);
    void updateMail(Mail mail, String email);
}
