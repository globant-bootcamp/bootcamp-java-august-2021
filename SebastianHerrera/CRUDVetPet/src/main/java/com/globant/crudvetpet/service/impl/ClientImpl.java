package com.globant.crudvetpet.service.impl;

import com.globant.crudvetpet.entity.Client;
import com.globant.crudvetpet.mapper.ClientMapper;
import com.globant.crudvetpet.model.ClientRequest;
import com.globant.crudvetpet.model.GenericResponse;
import com.globant.crudvetpet.repository.ClientRepository;
import com.globant.crudvetpet.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 08/09/21
 */
@Service
@RequiredArgsConstructor
public class ClientImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Value("${successfull.messages.success}")
    private String success;

    @Override
    public GenericResponse getAllClients() {
        List<Client> allClient = clientRepository.findAll();
        return GenericResponse.builder().response(success).genericResponseObject(allClient).build();
    }

    @Override
    public GenericResponse getClientById(Long idClient) {
        Client clientEntity = clientRepository.findById(idClient).orElse(null);
        ClientRequest clientRequest = clientMapper.clientEntityToModel(clientEntity);
        return GenericResponse.builder().response(success).genericResponseObject(clientRequest).build();
    }

    @Override
    public GenericResponse saveClient(ClientRequest clientRequest) {
        clientMapper.clientEntityToModel(clientRepository.save(clientMapper.clientModelToEntity(clientRequest)));
        return GenericResponse.builder().response(success).genericResponseObject(clientRequest).build();
    }

    @Override
    public GenericResponse updateClient(ClientRequest clientRequest, Long idClient) {

        Client clientById = clientRepository.findById(idClient).get();
        clientById.setClientName(clientRequest.getNameClient());
        clientById.setClientPhone(clientRequest.getPhoneClient());
        clientRepository.save(clientById);
        return GenericResponse.builder().response(success).genericResponseObject(clientById).build();

    }

    @Override
    public GenericResponse deleteClient(Long idClient) {
        Client client = clientRepository.findById(idClient).get();
        clientRepository.delete(client);
        return GenericResponse.builder().response(success).genericResponseObject(client).build();
    }

    @Override
    public boolean existsByClientId(Long idClient) {
        return clientRepository.existsById(idClient);
    }

}
