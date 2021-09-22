package com.vetpatitas.veterinary.dto;


import com.vetpatitas.veterinary.entity.Animal;
import com.vetpatitas.veterinary.entity.AnimalTreatment;


import java.util.List;


public class OwnerDTO {

    private long id;


    private String name;


    private String phoneNumber;


    private String email;


    private List<AnimalTreatment> animalTreatmentList;

    public OwnerDTO() {
    }

    public OwnerDTO(String name, String email, String phoneNumber, List animalTreatmentList) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.animalTreatmentList = animalTreatmentList;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<AnimalTreatment> getAnimalTreatmentList() {
        return animalTreatmentList;
    }

    public void setAnimalTreatmentList(List<AnimalTreatment> animalTreatmentList) {
        this.animalTreatmentList = animalTreatmentList;
    }
}
