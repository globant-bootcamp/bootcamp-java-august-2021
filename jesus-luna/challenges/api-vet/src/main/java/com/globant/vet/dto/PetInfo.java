package com.globant.vet.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetInfo {
	private String name;
	private String type;
	private int age;
	private LocalDate meeting;
}
