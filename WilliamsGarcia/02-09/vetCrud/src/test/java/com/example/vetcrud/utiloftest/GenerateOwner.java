package com.example.vetcrud.utiloftest;

import com.example.vetcrud.dto.OwnerDTO;
import com.example.vetcrud.entity.Owner;
import static com.example.vetcrud.utiloftest.ConstantsOfTest.NAME;
import static com.example.vetcrud.utiloftest.ConstantsOfTest.LAST_NAME;
import static com.example.vetcrud.utiloftest.ConstantsOfTest.ADDRESS;
import static com.example.vetcrud.utiloftest.ConstantsOfTest.CONTACT;
import static com.example.vetcrud.utiloftest.ConstantsOfTest.NUMBER_CYCLE;

import java.util.ArrayList;
import java.util.List;

public class GenerateOwner {

    public OwnerDTO createOwnerDTO(Long id) {
        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO.setId(id);
        ownerDTO.setName(NAME);
        ownerDTO.setLastName(LAST_NAME);
        ownerDTO.setAddress(ADDRESS);
        ownerDTO.setContact(CONTACT);

        return ownerDTO;
    }

    public Owner createOwner(Long id) {
        Owner owner = new Owner();
        owner.setId(id);
        owner.setName(NAME);
        owner.setLastName(LAST_NAME);
        owner.setAddress(ADDRESS);
        owner.setContact(CONTACT);

        return owner;
    }

    public List<Owner> createOwnerList() {
        List<Owner> ownerList = new ArrayList<>();
        for (int i = 0; i < NUMBER_CYCLE; i++) {
            ownerList.add(createOwner(Long.parseLong(String.valueOf(i))));
        }
        return ownerList;
    }

    public List<OwnerDTO> createOwnerDTOList() {
        List<OwnerDTO> ownerDTOList = new ArrayList<>();
        for (int i = 0; i < NUMBER_CYCLE; i++) {
            ownerDTOList.add(createOwnerDTO(Long.parseLong(String.valueOf(i))));
        }
        return ownerDTOList;
    }
}
