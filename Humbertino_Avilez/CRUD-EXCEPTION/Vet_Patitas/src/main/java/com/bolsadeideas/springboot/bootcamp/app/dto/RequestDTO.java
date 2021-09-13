package com.bolsadeideas.springboot.bootcamp.app.dto;

import com.bolsadeideas.springboot.bootcamp.app.entity.Owner;

public class RequestDTO {
	private Owner owner;

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public RequestDTO() {

	}

	public RequestDTO(Owner owner) {
		this.owner = owner;
	}
}
