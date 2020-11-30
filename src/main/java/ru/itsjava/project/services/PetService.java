package ru.itsjava.project.services;

import ru.itsjava.project.model.Pet;

public interface PetService {
    void printById(long id);
    void updatePet(Pet pet, String name, String type);
}
