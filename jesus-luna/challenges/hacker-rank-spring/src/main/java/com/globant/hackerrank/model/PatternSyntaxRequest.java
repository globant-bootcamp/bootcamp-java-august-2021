package com.globant.hackerrank.model;

import java.io.Serializable;
import java.util.List;

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
	private int numberOfPatterns;
	@NotNull(message = "patterns can not be null")
	@NotEmpty(message = "patterns can not be empty")
	private List<@NotBlank(message = "pattern can not be blank") String> patterns;
}
