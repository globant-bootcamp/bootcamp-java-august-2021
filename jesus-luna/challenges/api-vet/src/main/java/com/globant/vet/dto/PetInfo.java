package com.globant.vet.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetInfo {
	@NotEmpty(message = "name can not be neither empty nor null")
	private String name;
	@NotEmpty(message = "type can not be neither empty nor null")
	private String type;
	@Min(message = "age can not be negative", value = 0)
	private int age;
	private LocalDateTime meeting;
}
