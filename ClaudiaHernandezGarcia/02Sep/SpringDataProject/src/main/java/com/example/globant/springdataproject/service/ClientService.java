package com.example.globant.springdataproject.service;

import com.example.globant.springdataproject.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    ClientDTO addClient(ClientDTO clientDTO);
    List<ClientDTO> getClients();
    ClientDTO getClient(Long clientId);
    void deleteClientByID(Long clientId);
    ClientDTO editClientByID(Long clientId, ClientDTO clientDTO);
}
