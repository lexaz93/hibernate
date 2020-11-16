package ru.itsjava.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int age;

    @OneToOne(targetEntity = Mail.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "email_id")
    private Mail email;

    @OneToOne(targetEntity = Pet.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id")
    private Pet pet;
}
