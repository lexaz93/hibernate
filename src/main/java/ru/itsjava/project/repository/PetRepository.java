package ru.itsjava.project.repository;

import ru.itsjava.project.model.Pet;

import java.util.Optional;

public interface PetRepository {
    Pet save(Pet film);
    Optional<Pet> getById(long id);
    void updatePet(Pet film);
    void deleteById(long id);
}
