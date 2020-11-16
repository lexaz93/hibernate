package ru.itsjava.hibernate.repository;

import org.springframework.stereotype.Repository;
import ru.itsjava.hibernate.model.Pet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public class PetRepositoryImpl implements PetRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Pet save(Pet pet) {
        if (pet.getId() == 0l) {
            entityManager.persist(pet);
            return pet;
        }
        return entityManager.merge(pet);
    }

    @Override
    public Optional<Pet> getById(long id) {
        return Optional.ofNullable(entityManager.find(Pet.class, id));
    }

    @Override
    public void updatePet(Pet pet) {
        entityManager.merge(pet);
    }

    @Override
    public void deleteById(long id) {
        Pet pet = entityManager.find(Pet.class, id);
        entityManager.remove(pet);
    }
}
