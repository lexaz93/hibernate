package ru.itsjava.project.services.services;

import ru.itsjava.project.services.model.Mail;

public interface MailService {
    void printById(long id);
    void updateMail(Mail mail, String email);
}
