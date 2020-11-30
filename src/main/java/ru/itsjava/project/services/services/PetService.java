package ru.itsjava.project.services.services;

import ru.itsjava.project.services.model.Pet;

public interface PetService {
    void printById(long id);
    void updatePet(Pet pet, String name, String type);
}
