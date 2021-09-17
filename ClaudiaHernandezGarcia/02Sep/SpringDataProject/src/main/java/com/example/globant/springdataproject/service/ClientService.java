package com.example.globant.springdataproject.service;

import com.example.globant.springdataproject.dto.ClientDTO;
import com.example.globant.springdataproject.exception.InvalidDataException;

import java.util.List;

public interface ClientService {
    ClientDTO addClient(ClientDTO clientDTO) throws InvalidDataException;
    List<ClientDTO> getClients() throws InvalidDataException;
    ClientDTO getClient(Long clientId) throws InvalidDataException;
    void deleteClientByID(Long clientId) throws InvalidDataException;
    ClientDTO editClientByID(Long clientId, ClientDTO clientDTO) throws InvalidDataException;
}
