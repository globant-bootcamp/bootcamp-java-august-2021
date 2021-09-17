package com.globant.crudvetpet.controller;

import com.globant.crudvetpet.model.ClientRequest;
import com.globant.crudvetpet.model.GenericResponse;
import com.globant.crudvetpet.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 10/09/21
 */
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping(value = "${request.api.client}")
public class ClientController {

    private final ClientService clientService;

    @GetMapping(value = "${api.url.client.all-clients}")
    public ResponseEntity<GenericResponse> getAllClients() {
        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }

    @GetMapping(value = "${api.url.client.search-id-client}")
    public ResponseEntity<GenericResponse> getClientById(@Valid @PathVariable("idClient") Long idClient) {
        return new ResponseEntity<>(clientService.getClientById(idClient), HttpStatus.OK);
    }

    @PostMapping(value = "${api.url.client.add-client}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse> createClient(@Valid @RequestBody ClientRequest clientRequest) {
        return new ResponseEntity<>(clientService.saveClient(clientRequest), HttpStatus.CREATED);
    }

    @PutMapping(value = "${api.url.client.update-client}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse> updateClient(@Valid @PathVariable("idClient") Long idClient,
                                                        @RequestBody ClientRequest clientRequest) {
        return new ResponseEntity<>(clientService.updateClient(clientRequest, idClient), HttpStatus.OK);
    }

    @DeleteMapping(value = "${api.url.client.delete-client}")
    public ResponseEntity<GenericResponse> deleteClient(@Valid @PathVariable("idClient") Long idClient) {
        return new ResponseEntity<>(clientService.deleteClient(idClient), HttpStatus.OK);
    }


}
