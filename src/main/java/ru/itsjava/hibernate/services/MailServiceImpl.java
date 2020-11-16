package ru.itsjava.hibernate.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.hibernate.model.Mail;
import ru.itsjava.hibernate.repository.MailRepository;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class MailServiceImpl implements MailService {
    private final MailRepository mailRepository;

    @Transactional
    @Override
    public void printById(long id) {
        System.out.println(mailRepository.getById(id));
    }

    @Transactional
    @Override
    public void updateMail(Mail mail, String email) {
        mail.setEmail(email);
        mailRepository.updateMail(mail);
    }
}
