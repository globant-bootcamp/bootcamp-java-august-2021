package com.vetpatitas.veterinary.entity;

import javax.persistence.Entity;

import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;


@Entity
@Table(name = "animal_treatment")

public class AnimalTreatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "petId")
    private long petId;

    @Column(name = "medicine")
    private String medicine;

    @Column(name = "dateIn")
    private String dateIn;

    @Column(name = "dateOut")
    private String dateOut;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Owner owner;

    public AnimalTreatment() {

    }

    public AnimalTreatment(long id, long petId, String medicine, String dateIn, String dateOut, Owner owner) {
        this.id = id;
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
