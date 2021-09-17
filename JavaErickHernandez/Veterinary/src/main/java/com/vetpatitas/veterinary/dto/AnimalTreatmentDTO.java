package com.vetpatitas.veterinary.dto;


import com.vetpatitas.veterinary.entity.Owner;

import java.util.List;

public class AnimalTreatmentDTO {

    private long id;


    private long petId;


    private String medicine;


    private String dateIn;


    private String dateOut;


    private Owner owner;

    public AnimalTreatmentDTO() {

    }

    public AnimalTreatmentDTO(long petId, String medicine, String dateIn, String dateOut, Owner owner) {
        this.petId = petId;
        this.medicine = medicine;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getPetId() {
        return petId;
    }

    public void setPetId(long petId) {
        this.petId = petId;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }


}
