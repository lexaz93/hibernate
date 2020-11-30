package ru.itsjava.project.repository;

import org.springframework.stereotype.Repository;
import ru.itsjava.project.model.Mail;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class MailRepositoryImpl implements MailRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Mail save(Mail mail) {
        if (mail.getId() == 0L) {
            entityManager.persist(mail);
            return  mail;
        }
        return entityManager.merge(mail);
    }

    @Override
    public Optional<Mail> getById(long id) {
        return Optional.ofNullable(entityManager.find(Mail.class, id));
    }

    @Override
    public void updateMail(Mail mail) {
        entityManager.merge(mail);
    }

    @Override
    public void deleteById(long id) {
        Mail mail = entityManager.find(Mail.class, id);
        entityManager.remove(mail);
    }
}
