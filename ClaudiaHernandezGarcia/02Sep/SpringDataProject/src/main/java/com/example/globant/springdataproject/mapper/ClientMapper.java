package com.example.globant.springdataproject.mapper;

import com.example.globant.springdataproject.dto.ClientDTO;
import com.example.globant.springdataproject.dto.PetDTO;
import com.example.globant.springdataproject.entity.Client;
import com.example.globant.springdataproject.entity.Pet;
import com.example.globant.springdataproject.exception.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.example.globant.springdataproject.utils.Constants.INVALID_CLIENT_ID;

@Component
public class ClientMapper {

    @Autowired
    PetMapper petMapper;

    public Client clientDTOToEntity(ClientDTO clientDTO) {
        Client client = new Client();
        client.setFirstName(clientDTO.getFirstName());
        client.setLastName(clientDTO.getLastName());
        client.setPhoneNumber(clientDTO.getPhoneNumber());

        return client;
    }

    public ClientDTO clientEntityToDTO(Client client) throws InvalidDataException {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setFirstName(client.getFirstName());
        clientDTO.setLastName(client.getLastName());
        clientDTO.setPhoneNumber(client.getPhoneNumber());
        clientDTO.setPets(this.getPetListByClient(client));

        return clientDTO;
    }

    private List<PetDTO> getPetListByClient(Client client) throws InvalidDataException {
        List<PetDTO> petsList = new ArrayList<>();

        if (client != null) {
            if(client.getPets() != null) {
                for (Pet pet : client.getPets()) {
                    petsList.add(petMapper.petEntityToDTO(pet));
                }
            }
        } else {
            throw new InvalidDataException(INVALID_CLIENT_ID);
        }

        return petsList;
    }
}
