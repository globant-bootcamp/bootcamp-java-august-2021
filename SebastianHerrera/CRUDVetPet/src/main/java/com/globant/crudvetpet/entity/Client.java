package com.globant.crudvetpet.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 08/09/21
 */
@Data
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clients")
    private Long id;

    @NotBlank(message = "The client is null")
    @Column(name = "client_name")
    private String clientName;

    @NotBlank(message = "The client is null")
    @Column(name = "client_phone")
    private String clientPhone;

    @OneToMany
    @JoinColumn(name = "id_client")
    private List<Pet> ownerPets;

}
