package ru.itsjava.hibernate.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.hibernate.model.Pet;
import ru.itsjava.hibernate.repository.PetRepository;

@AllArgsConstructor
@Service
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;

    @Transactional(readOnly = true)
    @Override
    public void printById(long id) {
        System.out.println(petRepository.getById(id));
    }

    @Transactional
    @Override
    public void updatePet(Pet pet, String name, String type) {
        pet.setPetName(name);
        pet.setTypePet(type);
        petRepository.updatePet(pet);
    }
}
