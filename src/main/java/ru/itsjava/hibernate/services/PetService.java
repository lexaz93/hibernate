package ru.itsjava.hibernate.services;

import ru.itsjava.hibernate.model.Pet;

public interface PetService {
    void printById(long id);
    void updatePet(Pet pet, String name, String type);
}
