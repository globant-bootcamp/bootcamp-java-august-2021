package com.globant.hackerrank.model;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatternSyntaxRequest{
	@Min(value = 1,message = "numberOfPatterns must be greater than 0")
	private int numberOfPatterns;
	@NotNull(message = "patterns can not be null")
	@NotEmpty(message = "patterns can not be empty")
	private List<@NotBlank(message = "pattern can not be blank") String> patterns;
}
