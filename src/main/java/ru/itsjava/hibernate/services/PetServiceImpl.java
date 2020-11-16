package ru.itsjava.hibernate.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.hibernate.model.Pet;
import ru.itsjava.hibernate.repository.PetRepository;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;

    @Transactional
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
