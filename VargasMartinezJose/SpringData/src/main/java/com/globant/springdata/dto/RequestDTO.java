package com.globant.springdata.dto;

import com.globant.springdata.entity.Owner;

public class RequestDTO {
        private Owner owner;

        public Owner getOwner() {
            return owner;
        }

        public RequestDTO(Owner owner) {
            this.owner = owner;
        }
    }
