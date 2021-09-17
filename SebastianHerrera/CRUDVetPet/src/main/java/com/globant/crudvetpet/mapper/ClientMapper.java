package com.globant.crudvetpet.mapper;

import com.globant.crudvetpet.entity.Client;
import com.globant.crudvetpet.model.ClientRequest;
import org.springframework.stereotype.Component;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 09/09/21
 */
@Component
public class ClientMapper {

    public Client clientModelToEntity(ClientRequest clientRequest) {
        Client client = new Client();
        client.setClientName(clientRequest.getNameClient());
        client.setClientPhone(clientRequest.getPhoneClient());
        return client;
    }

    public ClientRequest clientEntityToModel(Client clientEntity) {
        ClientRequest clientRequest = new ClientRequest();
        clientRequest.setIdClient(clientEntity.getId());
        clientRequest.setPhoneClient(clientEntity.getClientPhone());
        clientRequest.setNameClient(clientEntity.getClientName());
        return clientRequest;
    }

}
