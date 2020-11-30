package ru.itsjava.hibernate.services.repository;

import ru.itsjava.hibernate.services.model.Pet;

import java.util.Optional;

public interface PetRepository {
    Pet save(Pet film);
    Optional<Pet> getById(long id);
    void updatePet(Pet film);
    void deleteById(long id);
}
