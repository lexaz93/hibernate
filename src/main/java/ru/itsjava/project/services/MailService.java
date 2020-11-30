package ru.itsjava.project.services;

import ru.itsjava.project.model.Mail;

public interface MailService {
    void printById(long id);
    void updateMail(Mail mail, String email);
}
