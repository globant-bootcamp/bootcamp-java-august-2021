package com.globant.vet.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "pet_id")
	private int id;
	@Column(name = "pet_name")
	private String name;
	@Column(name = "pet_type")
	private String type;
	@Column(name = "pet_age")
	private int age;
	private LocalDateTime meeting;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	private Customer owner;
}
