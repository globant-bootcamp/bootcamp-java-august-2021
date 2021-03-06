package com.globant.vet.dto;


import javax.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class PetInfoWithCompleteOwner extends PetInfo {
	@Valid
	private CustomerDTO<CustomerInfo> owner;
}
