package com.example.globant.springdataproject.service.impl;

import com.example.globant.springdataproject.dao.ClientDAO;
import com.example.globant.springdataproject.dto.ClientDTO;
import com.example.globant.springdataproject.entity.Client;
import com.example.globant.springdataproject.exception.InvalidDataException;
import com.example.globant.springdataproject.mapper.ClientMapper;
import com.example.globant.springdataproject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.globant.springdataproject.utils.Constants.MISSING_CLIENT_FIELDS;
import static com.example.globant.springdataproject.utils.Constants.CLIENT_ID_NOT_NULL;
import static com.example.globant.springdataproject.utils.Constants.INVALID_CLIENT_ID;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientMapper clientMapper;

    @Autowired
    ClientDAO clientDAO;

    @Override
    public ClientDTO addClient(ClientDTO clientDTO) {
        if (clientDTO.getFirstName() == null || clientDTO.getLastName() == null || clientDTO.getPhoneNumber() == null) {
            throw new InvalidDataException(MISSING_CLIENT_FIELDS);
        }

        Client client = clientMapper.clientDTOToEntity(clientDTO);
        Client clientSaved = clientDAO.save(client);
        ClientDTO newClientDTO = clientMapper.clientEntityToDTO(clientSaved);

        return newClientDTO;
    }

    @Override
    public List<ClientDTO> getClients() {
        List<Client> clients = clientDAO.findAll();
        List<ClientDTO> listClientsDTO = new ArrayList<>();

        for (Client client : clients) {
            listClientsDTO.add(clientMapper.clientEntityToDTO(client));
        }

        return listClientsDTO;
    }

    @Override
    public ClientDTO getClient(Long clientId) {
        if (clientId == null) {
            throw new InvalidDataException(CLIENT_ID_NOT_NULL);
        }

        Client client = clientDAO.findClientById(clientId);
        if (client == null) {
            throw new InvalidDataException(INVALID_CLIENT_ID);
        }

        ClientDTO clientRetrieved = clientMapper.clientEntityToDTO(client);
        return clientRetrieved;
    }

    @Override
    public void deleteClientByID(Long clientId) {
        if (clientId == null) {
            throw new InvalidDataException(CLIENT_ID_NOT_NULL);
        }

        clientDAO.deleteById(clientId);
    }

    @Override
    public ClientDTO editClientByID(Long clientId, ClientDTO clientDTO) {
        if (clientId == null) {
            throw new InvalidDataException(CLIENT_ID_NOT_NULL);
        }

        Client client = clientDAO.findClientById(clientId);
        if (client == null) {
            throw new InvalidDataException(INVALID_CLIENT_ID);
        }

        if (clientDTO.getFirstName() != null) {
            client.setFirstName(clientDTO.getFirstName());
        }

        if (clientDTO.getLastName() != null) {
            client.setLastName(clientDTO.getLastName());
        }

        if (clientDTO.getPhoneNumber() != null) {
            client.setPhoneNumber(clientDTO.getPhoneNumber());
        }

        Client clientSaved = clientDAO.save(client);
        ClientDTO newClientDTO = clientMapper.clientEntityToDTO(clientSaved);

        return newClientDTO;
    }
}
