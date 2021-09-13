package com.globant.vet.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInfo {
	@NotEmpty(message="cusomer name can not be neither null nor empty")
	private String name;
}
