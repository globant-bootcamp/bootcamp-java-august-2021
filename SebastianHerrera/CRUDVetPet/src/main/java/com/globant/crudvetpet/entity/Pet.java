package com.globant.crudvetpet.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 06/09/21
 */
@Data
@Entity
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pet")
    private Long id;

    @Column(name = "name_pet")
    private String petName;

    @Column(name = "type_pet")
    private String petType;

    @Column(name = "age_pet")
    private String petAge;

    @NotNull
    @Column(name = "id_client")
    private Long idOwner;
}
