package com.bootcamp.springdatajpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "owner")
public class Owner {

  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_address")
  private Address address;

  @Column
  private String firstName;
  @Column
  private String lastName;
  @Column
  private int age;
  @Column
  private String email;
  @Column
  private String phone;
  @Column
  private boolean active;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address id_address) {
    this.address = id_address;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String first_name) {
    this.firstName = first_name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String last_name) {
    this.lastName = last_name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }
}
