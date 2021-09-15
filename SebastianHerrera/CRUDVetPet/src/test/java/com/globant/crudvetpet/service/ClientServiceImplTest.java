package com.globant.crudvetpet.service;

import com.globant.crudvetpet.entity.Client;
import com.globant.crudvetpet.mapper.ClientMapper;
import com.globant.crudvetpet.model.ClientRequest;
import com.globant.crudvetpet.model.GenericResponse;
import com.globant.crudvetpet.repository.ClientRepository;
import com.globant.crudvetpet.service.impl.ClientImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 12/09/21
 */
@RunWith(MockitoJUnitRunner.class)
public class ClientServiceImplTest {
    @InjectMocks
    private ClientImpl clientService;

    @Mock
    ClientMapper clientMapper;

    @Mock
    ClientRepository clientRepository;

    @Mock
    GenericResponse genericResponse;

    @Test
    public void findAllClientTestSucces(){
        Client client = new Client();
        client.setId(1L);
        client.setClientName("Loquesea");
        client.setClientPhone("4564563");

        when(clientRepository.findAll()).thenReturn((List<Client>) client);

        GenericResponse genericResponse = clientService.getAllClients();

        assertNotNull(genericResponse.getGenericResponseObject());
    }

    @Test
    public void addClientsTestSucces() {

        ClientRequest clientDTORequest = new ClientRequest();
        clientDTORequest.setNameClient("Sebastian");
        clientDTORequest.setPhoneClient("5544112233");

        ClientRequest clientDTOResponse = new ClientRequest();
        clientDTOResponse.setIdClient(1L);
        clientDTOResponse.setNameClient("Sebastian");
        clientDTOResponse.setPhoneClient("5544112233");

        Client clientRequest = new Client();
        clientRequest.setClientName("Sebastian");
        clientRequest.setClientPhone("5544112233");

        Client clientResponse = new Client();
        clientResponse.setId(1L);
        clientResponse.setClientName("Sebastian");
        clientResponse.setClientPhone("5544112233");

        when(clientMapper.clientModelToEntity(any(ClientRequest.class))).thenReturn(clientResponse);
        when(clientRepository.save(any(Client.class))).thenReturn(clientResponse);
        when(clientMapper.clientEntityToModel(any(Client.class))).thenReturn(clientDTOResponse);

        GenericResponse genericResponse = clientService.saveClient(clientDTORequest);

        assertNotNull(genericResponse.getGenericResponseObject());
        assertEquals(genericResponse.getGenericResponseObject(), clientDTORequest);
    }
    @Test
    public void addClientsTestFail(){
        ClientRequest clientDTORequest = new ClientRequest();
        clientDTORequest.setNameClient("");
        clientDTORequest.setPhoneClient("5544112233");

        ClientRequest clientDTOResponse = new ClientRequest();
        clientDTOResponse.setIdClient(1L);
        clientDTOResponse.setNameClient("Sebastian");
        clientDTOResponse.setPhoneClient("5544112233");

        Client clientRequest = new Client();
        clientRequest.setClientName("Sebastian");
        clientRequest.setClientPhone("5544112233");

        Client clientResponse = new Client();
        clientResponse.setId(1L);
        clientResponse.setClientName("Sebastian");
        clientResponse.setClientPhone("5544112233");

        when(clientMapper.clientModelToEntity(any(ClientRequest.class))).thenReturn(clientResponse);
        when(clientRepository.save(any(Client.class))).thenReturn(clientResponse);
        when(clientMapper.clientEntityToModel(any(Client.class))).thenReturn(clientDTOResponse);

        GenericResponse genericResponse = clientService.saveClient(clientDTORequest);

        assertNotEquals(genericResponse.getGenericResponseObject(),clientDTOResponse);

    }

    @Test
    public void testClientByIdSuccess() {
        Client client = new Client();
        client.setId(1L);

        ClientRequest clientRequest = new ClientRequest();
        clientRequest.setIdClient(1L);

        when(clientRepository.findById(any())).thenReturn(Optional.of(client));
        when(clientMapper.clientEntityToModel(client)).thenReturn(clientRequest);

        GenericResponse genericResponse = clientService.getClientById(1L);

        assertNotNull(genericResponse.getGenericResponseObject());
        assertEquals(genericResponse.getGenericResponseObject(), clientRequest);

    }

    @Test
    public void testClientByIdFail (){
        Client client = new Client();
        client.setId(1L);

        ClientRequest clientRequest = new ClientRequest();
        clientRequest.setIdClient(1L);

        when(clientRepository.findById(any())).thenReturn(Optional.of(client));
        when(clientMapper.clientEntityToModel(any(Client.class))).thenReturn(clientRequest);

        genericResponse = clientService.getClientById(null);

        assertNotEquals(genericResponse.getGenericResponseObject(),client);
    }








}
