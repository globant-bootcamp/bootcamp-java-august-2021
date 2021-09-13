package com.bootcamp.springdatacrud.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pet_owner")
public class PetOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @OneToMany(targetEntity = Pet.class,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ownerpet_fk", referencedColumnName = "id")
    private List<Pet> pets;

    public PetOwner() {
        pets = new ArrayList<Pet>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Pet> getPet() {
        return pets;
    }

    public void setPet(List<Pet> pets) {
        this.pets = pets;
    }

}
