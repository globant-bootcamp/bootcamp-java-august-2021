package com.vetpatitas.veterinary.dto;

public class AnimalDTO {


    private long id;


    private String name;


    private String species;


    private long ownerId;

    public AnimalDTO() {

    }

    public AnimalDTO(String name, String species, long ownerId) {
        this.name = name;
        this.species = species;
        this.ownerId = ownerId;
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

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }


}
