package com.example.globant.springdataproject.controller;

import com.example.globant.springdataproject.dto.ClientDTO;
import com.example.globant.springdataproject.dto.ResponseDTO;
import com.example.globant.springdataproject.entity.Client;
import com.example.globant.springdataproject.service.ClientService;
import com.example.globant.springdataproject.utils.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static com.example.globant.springdataproject.utils.Constants.CLIENT_ADDED_SUCCESSFULLY;
import static com.example.globant.springdataproject.utils.Constants.CLIENT_DELETED_SUCCESSFULLY;
import static com.example.globant.springdataproject.utils.Constants.CLIENT_EDITED_SUCCESSFULLY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientControllerTest {
    @InjectMocks
    private ClientController clientController;

    @Mock
    private ClientService clientService;

    @Test
    public void addClientTest_OK() {
        ClientDTO clientDTORequest = new ClientDTO();
        clientDTORequest.setFirstName("client name");
        clientDTORequest.setLastName("client last name");
        clientDTORequest.setPhoneNumber("12346");

        ClientDTO clientDTOResponse = new ClientDTO();
        clientDTOResponse.setId(1L);
        clientDTOResponse.setFirstName("client name");
        clientDTOResponse.setLastName("client last name");
        clientDTOResponse.setPhoneNumber("12346");
        clientDTOResponse.setPets(new ArrayList<>());

        when(clientService.addClient(any(ClientDTO.class))).thenReturn(clientDTOResponse);

        ResponseEntity<ResponseDTO<ClientDTO>> response = clientController.addClient(clientDTORequest);

        assertNotNull(response);

        assertEquals(response.getBody().getResponseConstants(), Constants.ResponseConstants.SUCCESS);
        assertEquals(response.getBody().getMessage(), CLIENT_ADDED_SUCCESSFULLY);
        assertEquals(response.getBody().getContent().getFirstName(), clientDTORequest.getFirstName());
        assertEquals(response.getBody().getContent().getLastName(), clientDTORequest.getLastName());
        assertEquals(response.getBody().getContent().getPhoneNumber(), clientDTORequest.getPhoneNumber());

        Mockito.verify(clientService, times(1)).addClient(any(ClientDTO.class));
    }

    @Test
    public void getClientsTest_OK() {
        Client clientResponse = new Client();
        clientResponse.setId(1L);
        clientResponse.setFirstName("client name");
        clientResponse.setLastName("client last name");
        clientResponse.setPhoneNumber("12345678");
        clientResponse.setPets(new ArrayList<>());

        List<Client> clientsResponse = new ArrayList<>();
        clientsResponse.add(clientResponse);

        List<ClientDTO> clientsDTOResponse = new ArrayList<>();
        ClientDTO clientDTOResponse = new ClientDTO();
        clientDTOResponse.setId(1L);
        clientDTOResponse.setFirstName("client name");
        clientDTOResponse.setLastName("client last name");
        clientDTOResponse.setPhoneNumber("12345678");
        clientDTOResponse.setPets(new ArrayList<>());
        clientsDTOResponse.add(clientDTOResponse);

        when(clientService.getClients()).thenReturn(clientsDTOResponse);

        ResponseEntity<ResponseDTO<List<ClientDTO>>> response = clientController.getClients();

        assertNotNull(response);

        assertEquals(response.getBody().getResponseConstants(), Constants.ResponseConstants.SUCCESS);
        assertEquals(response.getBody().getMessage(), "");
        assertEquals(response.getBody().getContent(), clientsDTOResponse);
        assertEquals(response.getBody().getContent().size(), 1);

        Mockito.verify(clientService, times(1)).getClients();
    }

    @Test
    public void getClientByIDTest_OK() {
        Long idRequest = 1L;

        Client clientResponse = new Client();
        clientResponse.setId(1L);
        clientResponse.setFirstName("client name");
        clientResponse.setLastName("client last name");
        clientResponse.setPhoneNumber("12345678");
        clientResponse.setPets(new ArrayList<>());

        ClientDTO clientDTOResponse = new ClientDTO();
        clientDTOResponse.setId(1L);
        clientDTOResponse.setFirstName("client name");
        clientDTOResponse.setLastName("client last name");
        clientDTOResponse.setPhoneNumber("12345678");
        clientDTOResponse.setPets(new ArrayList<>());

        when(clientService.getClient(any(Long.class))).thenReturn(clientDTOResponse);

        ResponseEntity<ResponseDTO<ClientDTO>> response = clientController.getClient(idRequest);

        assertNotNull(response);

        assertEquals(response.getBody().getResponseConstants(), Constants.ResponseConstants.SUCCESS);
        assertEquals(response.getBody().getMessage(), "");
        assertEquals(response.getBody().getContent(), clientDTOResponse);
        assertEquals(response.getBody().getContent().getId(), idRequest);

        Mockito.verify(clientService, times(1)).getClient(any(Long.class));
    }

    @Test
    public void deletePetByIDTest_OK() {
        Long idRequest = 1L;

        ResponseEntity<ResponseDTO<ClientDTO>> response = clientController.deletePetByID(idRequest);

        assertNotNull(response);

        assertEquals(response.getBody().getResponseConstants(), Constants.ResponseConstants.SUCCESS);
        assertEquals(response.getBody().getMessage(), CLIENT_DELETED_SUCCESSFULLY);
        assertEquals(response.getBody().getContent(), null);

        Mockito.verify(clientService, times(1)).deleteClientByID(any(Long.class));
    }

    @Test
    public void editPetByIDTest_OK() {
        Long idRequest = 1L;
        ClientDTO clientDTORequest = new ClientDTO();
        clientDTORequest.setFirstName("name");
        clientDTORequest.setLastName("last name");
        clientDTORequest.setPhoneNumber("789");

        ClientDTO clientDTOResponse = new ClientDTO();
        clientDTOResponse.setId(1L);
        clientDTOResponse.setFirstName("name");
        clientDTOResponse.setLastName("last name");
        clientDTOResponse.setPhoneNumber("789");
        clientDTOResponse.setPets(new ArrayList<>());

        when(clientService.editClientByID(any(Long.class), any(ClientDTO.class))).thenReturn(clientDTOResponse);

        ResponseEntity<ResponseDTO<ClientDTO>> response = clientController.editPetByID(idRequest, clientDTORequest);

        assertNotNull(response);

        assertEquals(response.getBody().getResponseConstants(), Constants.ResponseConstants.SUCCESS);
        assertEquals(response.getBody().getMessage(), CLIENT_EDITED_SUCCESSFULLY);
        assertEquals(response.getBody().getContent(), clientDTOResponse);
        assertEquals(response.getBody().getContent().getId(), idRequest);
        assertEquals(response.getBody().getContent().getFirstName(), clientDTORequest.getFirstName());
        assertEquals(response.getBody().getContent().getLastName(), clientDTORequest.getLastName());

        Mockito.verify(clientService, times(1)).editClientByID(any(Long.class), any(ClientDTO.class));

    }
}
