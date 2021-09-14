package com.bootcamp.springdatajpa.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class AddressDTO {

  public Long id;
  @NotBlank
  public String street;
  @NotEmpty
  public int extNumber;
  public int intNumber;
  @NotBlank
  public String colony;
  @NotBlank
  public String municipality;
  @NotBlank
  public String state;
  @NotEmpty
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

  public void setExtNumber(int extNumber) {
    this.extNumber = extNumber;
  }

  public int getIntNumber() {
    return intNumber;
  }

  public void setIntNumber(int intNumber) {
    this.intNumber = intNumber;
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

  public void setZipCode(int zipCode) {
    this.zipCode = zipCode;
  }

}
