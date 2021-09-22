package com.bootcamp.Vet_Patitas.entity;

import javax.persistence.*;

@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long petId;

    @Column(name = "name")
    private String petName;

    @Column(name = "race")
    private String petRace;

    @Column(name = "weight")
    private double petWeight;

    @Column(name = "owner")
    private String petOwner;

    @Column(name = "phone_number")
    private int petPhoneNumber;

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public String getName() {
        return petName;
    }

    public void setName(String name) {
        this.petName = name;
    }

    public String getPetRace() {
        return petRace;
    }

    public void setPetRace(String petRace) {
        this.petRace = petRace;
    }

    public double getPetWeight() {
        return petWeight;
    }

    public void setPetWeight(double petWeight) {
        this.petWeight = petWeight;
    }

    public String getPetOwner() {
        return petOwner;
    }

    public void setPetOwner(String petOwner) {
        this.petOwner = petOwner;
    }

    public int getPetPhoneNumber() {
        return petPhoneNumber;
    }

    public void setPetPhoneNumber(int petPhoneNumber) {
        this.petPhoneNumber = petPhoneNumber;
    }

    public Pet(String petName, String race, double weight, String owner, int phoneNumber) {

        this.petName = petName;
        this.petRace = race;
        this.petWeight = weight;
        this.petOwner = owner;
        this.petPhoneNumber = phoneNumber;
    }

    public Pet(){}
}
