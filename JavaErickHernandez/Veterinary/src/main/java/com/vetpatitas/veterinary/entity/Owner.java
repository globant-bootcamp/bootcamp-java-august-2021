package com.vetpatitas.veterinary.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.List;

@Entity
@Table(name = "owner_info")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "owner")
    private List<AnimalTreatment> animalTreatmentList;

    public Owner() {
    }

    public Owner(String name, String email, String phoneNumber, List animalTreatmentList) {
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
