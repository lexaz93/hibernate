package ru.itsjava.project.services.repository;

import org.springframework.stereotype.Repository;
import ru.itsjava.project.services.model.Pet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class PetRepositoryImpl implements PetRepository {
    @PersistenceContext
    private EntityManager entityManager;

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
