package com.bootcamp.springdatajpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  @Column
  public String street;
  @Column
  public int extNumber;
  @Column
  public int intNumber;
  @Column
  public String colony;
  @Column
  public String municipality;
  @Column
  public String state;
  @Column
  public int zipCode;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public int getExtNumber() {
    return extNumber;
  }

  public void setExtNumber(int ext_number) {
    this.extNumber = ext_number;
  }

  public int getIntNumber() {
    return intNumber;
  }

  public void setIntNumber(int int_number) {
    this.intNumber = int_number;
  }

  public String getColony() {
    return colony;
  }

  public void setColony(String colony) {
    this.colony = colony;
  }

  public String getMunicipality() {
    return municipality;
  }

  public void setMunicipality(String municipality) {
    this.municipality = municipality;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public int getZipCode() {
    return zipCode;
  }

  public void setZipCode(int zip_code) {
    this.zipCode = zip_code;
  }

}
