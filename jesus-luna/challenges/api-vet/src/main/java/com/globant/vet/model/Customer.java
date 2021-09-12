package com.globant.vet.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int id;
	@Column(name = "customer_name")
	private String name;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "owner",fetch = FetchType.LAZY)
	private List<Pet> pets;
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", petsSize=" + pets.size() + "]";
	}
	
	

}
