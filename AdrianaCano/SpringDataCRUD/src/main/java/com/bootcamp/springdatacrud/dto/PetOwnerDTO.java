package com.bootcamp.springdatacrud.dto;

import java.util.ArrayList;
import java.util.List;

public class PetOwnerDTO {
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private List<PetDTO> pets;

    public PetOwnerDTO(){
        pets = new ArrayList<>();
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

    public void addPet(PetDTO petDTO) {
        pets.add(petDTO);
    }
}
