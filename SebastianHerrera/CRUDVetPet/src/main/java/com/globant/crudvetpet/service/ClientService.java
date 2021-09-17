package com.globant.crudvetpet.service;

import com.globant.crudvetpet.model.ClientRequest;
import com.globant.crudvetpet.model.GenericResponse;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 08/09/21
 */
public interface ClientService {

    GenericResponse getAllClients();

    GenericResponse getClientById(Long idClient);

    GenericResponse saveClient(ClientRequest clientRequest);

    GenericResponse updateClient(ClientRequest clientRequest, Long idClient);

    GenericResponse deleteClient(Long idClient);

    boolean existsByClientId(Long idClient);


}
