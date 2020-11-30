package ru.itsjava.project.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.project.repository.MailRepository;
import ru.itsjava.project.model.Mail;

@AllArgsConstructor
@Service
public class MailServiceImpl implements MailService {
    private final MailRepository mailRepository;

    @Transactional(readOnly = true)
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
