package ru.itsjava.hibernate.services.services;

import ru.itsjava.hibernate.services.model.Pet;

public interface PetService {
    void printById(long id);
    void updatePet(Pet pet, String name, String type);
}
