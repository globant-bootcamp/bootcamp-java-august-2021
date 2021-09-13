package com.globant.vet.dto;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO<T> {
	private int id;
	@JsonProperty(value = "data")
	@Valid
	private T customer;
}
