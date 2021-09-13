package com.globant.hackerrank.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO<T> {
	@Valid
	@NotNull(message = "data can not be null")
	private T data;
}
