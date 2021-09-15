package com.example.globant.springdataproject.service;

import com.example.globant.springdataproject.dao.ClientDAO;
import com.example.globant.springdataproject.dto.ClientDTO;
import com.example.globant.springdataproject.entity.Client;
import com.example.globant.springdataproject.exception.InvalidDataException;
import com.example.globant.springdataproject.mapper.ClientMapper;
import com.example.globant.springdataproject.service.impl.ClientServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceImplTest {

    @InjectMocks
    private ClientServiceImpl clientService;

    @Mock
    private ClientMapper clientMapper;

    @Mock
    private ClientDAO clientDAO;

    @Test
    public void addClientTest_WithAllFields_Ok() {
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

        Client clientRequest = new Client();
        clientRequest.setFirstName("client name");
        clientRequest.setLastName("client last name");
        clientRequest.setPhoneNumber("12346");
        clientRequest.setPets(new ArrayList<>());

        Client clientResponse = new Client();
        clientResponse.setId(1L);
        clientResponse.setFirstName("client name");
        clientResponse.setLastName("client last name");
        clientResponse.setPhoneNumber("12346");
        clientResponse.setPets(new ArrayList<>());

        when(clientMapper.clientDTOToEntity(any(ClientDTO.class))).thenReturn(clientRequest);
        when(clientDAO.save(any(Client.class))).thenReturn(clientResponse);
        when(clientMapper.clientEntityToDTO(any(Client.class))).thenReturn(clientDTOResponse);

        ClientDTO response = clientService.addClient(clientDTORequest);

        assertNotNull(response);
        assertEquals(response, clientDTOResponse);

        assertEquals(response.getId(), clientDTOResponse.getId());
        assertEquals(response.getFirstName(), clientDTORequest.getFirstName());
        assertEquals(response.getLastName(), clientDTORequest.getLastName());
        assertEquals(response.getPhoneNumber(), clientDTORequest.getPhoneNumber());

        Mockito.verify(clientDAO, times(1)).save(any(Client.class));
    }

    @Test(expected = InvalidDataException.class)
    public void addClientTest_WithMissingFields_ThemInvalidDataException() {
        ClientDTO clientDTORequest = new ClientDTO();
        clientDTORequest.setFirstName("Client name");
        clientDTORequest.setLastName("Client last name");

        clientService.addClient(clientDTORequest);
    }

    @Test
    public void getClientsTest_Ok() {
        List<Client> clientsResponse = new ArrayList<>();
        Client clientResponse = new Client();
        clientResponse.setId(1L);
        clientResponse.setFirstName("client name");
        clientResponse.setLastName("client last name");
        clientResponse.setPhoneNumber("12345678");
        clientResponse.setPets(new ArrayList<>());
        clientsResponse.add(clientResponse);

        List<ClientDTO> clientsDTOResponse = new ArrayList<>();
        ClientDTO clientDTOResponse = new ClientDTO();
        clientDTOResponse.setId(1L);
        clientDTOResponse.setFirstName("client name");
        clientDTOResponse.setLastName("client last name");
        clientDTOResponse.setPhoneNumber("12345678");
        clientDTOResponse.setPets(new ArrayList<>());
        clientsDTOResponse.add(clientDTOResponse);

        when(clientDAO.findAll()).thenReturn(clientsResponse);
        when(clientMapper.clientEntityToDTO(any(Client.class))).thenReturn(clientDTOResponse);

        List<ClientDTO> response = clientService.getClients();

        assertNotNull(response);
        assertEquals(response, clientsDTOResponse);

        Mockito.verify(clientDAO, times(1)).findAll();
    }

    @Test
    public void getClientByIDTes_WithClientIdValid_Ok() {
        Long clientIdRequest = 1L;

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

        when(clientDAO.findClientById(any())).thenReturn(clientResponse);
        when(clientMapper.clientEntityToDTO(any(Client.class))).thenReturn(clientDTOResponse);

        ClientDTO response = clientService.getClient(clientIdRequest);

        assertNotNull(response);
        assertEquals(response, clientDTOResponse);

        Mockito.verify(clientDAO, times(1)).findClientById(clientIdRequest);
    }

    @Test(expected = InvalidDataException.class)
    public void getClientTest_WithClientIdNull_ThemInvalidDataException() {
        clientService.getClient(null);
    }

    @Test(expected = InvalidDataException.class)
    public void getClientTest_WithClientIdInvalid_ThemInvalidDataException() {
        Long clientIdRequest = 1L;

        when(clientDAO.findClientById(any())).thenReturn(null);
        clientService.getClient(clientIdRequest);
    }

    @Test
    public void deleteClientTest_WithClientIdValid_Ok() {
        Long clientIdRequest = 1L;

        clientService.deleteClientByID(clientIdRequest);

        Mockito.verify(clientDAO, times(1)).deleteById(any(Long.class));
    }

    @Test(expected = InvalidDataException.class)
    public void deleteClientTest_WithClientIdNull_ThemInvalidDataException() {
        clientService.deleteClientByID(null);
    }

    @Test
    public void editClientTest_WithClientIdValid_Ok() {
        Long clientIdRequest = 1L;
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

        Client clientResponse = new Client();
        clientResponse.setId(1L);
        clientResponse.setFirstName("client name");
        clientResponse.setLastName("client last name");
        clientResponse.setPhoneNumber("12346");
        clientResponse.setPets(new ArrayList<>());

        Client modifiedClientResponse = new Client();
        modifiedClientResponse.setId(1L);
        modifiedClientResponse.setFirstName("name");
        modifiedClientResponse.setLastName("last name");
        modifiedClientResponse.setPhoneNumber("789");
        modifiedClientResponse.setPets(new ArrayList<>());

        when(clientDAO.findClientById(any())).thenReturn(clientResponse);
        when(clientDAO.save(any(Client.class))).thenReturn(modifiedClientResponse);
        when(clientMapper.clientEntityToDTO(any(Client.class))).thenReturn(clientDTOResponse);

        ClientDTO response = clientService.editClientByID(clientIdRequest, clientDTORequest);

        assertNotNull(response);
        assertEquals(response, clientDTOResponse);

        assertEquals(response.getId(), clientDTOResponse.getId());
        assertEquals(response.getFirstName(), clientDTORequest.getFirstName());
        assertEquals(response.getLastName(), clientDTORequest.getLastName());
        assertEquals(response.getPhoneNumber(), clientDTORequest.getPhoneNumber());

        Mockito.verify(clientDAO, times(1)).save(any(Client.class));
    }

    @Test
    public void editClientTest_WithValidClientId_AndOnlyClientFirstName_OK() {
        Long clientIdRequest = 1L;
        ClientDTO clientDTORequest = new ClientDTO();
        clientDTORequest.setFirstName("name");

        ClientDTO clientDTOResponse = new ClientDTO();
        clientDTOResponse.setId(1L);
        clientDTOResponse.setFirstName("name");
        clientDTOResponse.setLastName("client last name");
        clientDTOResponse.setPhoneNumber("12346");
        clientDTOResponse.setPets(new ArrayList<>());

        Client clientResponse = new Client();
        clientResponse.setId(1L);
        clientResponse.setFirstName("client name");
        clientResponse.setLastName("client last name");
        clientResponse.setPhoneNumber("12346");
        clientResponse.setPets(new ArrayList<>());

        Client modifiedClientResponse = new Client();
        modifiedClientResponse.setId(1L);
        modifiedClientResponse.setFirstName("name");
        modifiedClientResponse.setLastName("client last name");
        modifiedClientResponse.setPhoneNumber("12346");
        modifiedClientResponse.setPets(new ArrayList<>());

        when(clientDAO.findClientById(any())).thenReturn(clientResponse);
        when(clientDAO.save(any(Client.class))).thenReturn(modifiedClientResponse);
        when(clientMapper.clientEntityToDTO(any(Client.class))).thenReturn(clientDTOResponse);

        ClientDTO response = clientService.editClientByID(clientIdRequest, clientDTORequest);

        assertNotNull(response);
        assertEquals(response, clientDTOResponse);

        assertEquals(response.getId(), clientDTOResponse.getId());
        assertEquals(response.getFirstName(), clientDTORequest.getFirstName());
        assertEquals(response.getLastName(), clientDTOResponse.getLastName());
        assertEquals(response.getPhoneNumber(), clientDTOResponse.getPhoneNumber());

        Mockito.verify(clientDAO, times(1)).save(any(Client.class));
    }

    @Test
    public void editClientTest_WithValidClientId_AndOnlyClientLastName_OK() {
        Long clientIdRequest = 1L;
        ClientDTO clientDTORequest = new ClientDTO();
        clientDTORequest.setLastName("last name");

        ClientDTO clientDTOResponse = new ClientDTO();
        clientDTOResponse.setId(1L);
        clientDTOResponse.setFirstName("client name");
        clientDTOResponse.setLastName("last name");
        clientDTOResponse.setPhoneNumber("12346");
        clientDTOResponse.setPets(new ArrayList<>());

        Client clientResponse = new Client();
        clientResponse.setId(1L);
        clientResponse.setFirstName("client name");
        clientResponse.setLastName("client last name");
        clientResponse.setPhoneNumber("12346");
        clientResponse.setPets(new ArrayList<>());

        Client modifiedClientResponse = new Client();
        modifiedClientResponse.setId(1L);
        modifiedClientResponse.setFirstName("client name");
        modifiedClientResponse.setLastName("last name");
        modifiedClientResponse.setPhoneNumber("12346");
        modifiedClientResponse.setPets(new ArrayList<>());

        when(clientDAO.findClientById(any())).thenReturn(clientResponse);
        when(clientDAO.save(any(Client.class))).thenReturn(modifiedClientResponse);
        when(clientMapper.clientEntityToDTO(any(Client.class))).thenReturn(clientDTOResponse);

        ClientDTO response = clientService.editClientByID(clientIdRequest, clientDTORequest);

        assertNotNull(response);
        assertEquals(response, clientDTOResponse);

        assertEquals(response.getId(), clientDTOResponse.getId());
        assertEquals(response.getFirstName(), clientDTOResponse.getFirstName());
        assertEquals(response.getLastName(), clientDTORequest.getLastName());
        assertEquals(response.getPhoneNumber(), clientDTOResponse.getPhoneNumber());

        Mockito.verify(clientDAO, times(1)).save(any(Client.class));
    }

    @Test
    public void editClientTest_WithValidClientId_AndOnlyClientPhoneNumber_OK() {
        Long clientIdRequest = 1L;
        ClientDTO clientDTORequest = new ClientDTO();
        clientDTORequest.setPhoneNumber("789");

        ClientDTO clientDTOResponse = new ClientDTO();
        clientDTOResponse.setId(1L);
        clientDTOResponse.setFirstName("client name");
        clientDTOResponse.setLastName("client last name");
        clientDTOResponse.setPhoneNumber("789");
        clientDTOResponse.setPets(new ArrayList<>());

        Client clientResponse = new Client();
        clientResponse.setId(1L);
        clientResponse.setFirstName("client name");
        clientResponse.setLastName("client last name");
        clientResponse.setPhoneNumber("12346");
        clientResponse.setPets(new ArrayList<>());

        Client modifiedClientResponse = new Client();
        modifiedClientResponse.setId(1L);
        modifiedClientResponse.setFirstName("client name");
        modifiedClientResponse.setLastName("client last name");
        modifiedClientResponse.setPhoneNumber("789");
        modifiedClientResponse.setPets(new ArrayList<>());

        when(clientDAO.findClientById(any())).thenReturn(clientResponse);
        when(clientDAO.save(any(Client.class))).thenReturn(modifiedClientResponse);
        when(clientMapper.clientEntityToDTO(any(Client.class))).thenReturn(clientDTOResponse);

        ClientDTO response = clientService.editClientByID(clientIdRequest, clientDTORequest);

        assertNotNull(response);
        assertEquals(response, clientDTOResponse);

        assertEquals(response.getId(), clientDTOResponse.getId());
        assertEquals(response.getFirstName(), clientDTOResponse.getFirstName());
        assertEquals(response.getLastName(), clientDTOResponse.getLastName());
        assertEquals(response.getPhoneNumber(), clientDTORequest.getPhoneNumber());

        Mockito.verify(clientDAO, times(1)).save(any(Client.class));
    }

    @Test(expected = InvalidDataException.class)
    public void editClientTest_WithClientIdNull_ThemInvalidDataException() {
        ClientDTO clientDTORequest = new ClientDTO();
        clientDTORequest.setFirstName("client name");
        clientDTORequest.setLastName("client last name");
        clientDTORequest.setPhoneNumber("12346");

        clientService.editClientByID(null, clientDTORequest);
    }

    @Test(expected = InvalidDataException.class)
    public void editClientTest_WithInvalidClientId_ThemInvalidDataException() {
        ClientDTO clientDTORequest = new ClientDTO();
        clientDTORequest.setFirstName("client name");
        clientDTORequest.setLastName("client last name");
        clientDTORequest.setPhoneNumber("12346");

        clientService.editClientByID(1L, clientDTORequest);
    }
}
