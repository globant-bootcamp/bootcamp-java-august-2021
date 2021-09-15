package com.vetpatitas.veterinary.test;

import com.vetpatitas.veterinary.dao.AnimalTreatmentDAO;
import com.vetpatitas.veterinary.dto.AnimalTreatmentDTO;
import com.vetpatitas.veterinary.entity.AnimalTreatment;
import com.vetpatitas.veterinary.entity.Owner;
import com.vetpatitas.veterinary.exception.InvalidDataException;
import com.vetpatitas.veterinary.mapper.AnimalTreatmentMapper;
import com.vetpatitas.veterinary.service.implementation.TreatmentServiceImplementation;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;


import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class AnimalTreatmentServiceImplTest {
    @InjectMocks
    private TreatmentServiceImplementation animalTreatmentService;

    @Mock
    AnimalTreatmentDAO animalTreatmentDAO;

    @Mock
    AnimalTreatmentMapper animalTreatmentMapper;

    private Owner owner = new Owner();

    @Test
    public void addAnimalTreatmentTest() {

        AnimalTreatmentDTO animalTreatmentDTORequest = new AnimalTreatmentDTO();
        animalTreatmentDTORequest.setId(1L);
        animalTreatmentDTORequest.setPetId(1L);
        animalTreatmentDTORequest.setMedicine("GENERIC NAME");
        animalTreatmentDTORequest.setDateIn("GENERIC EMAIL");
        animalTreatmentDTORequest.setDateOut("GENERIC PHONE Number");
        animalTreatmentDTORequest.setOwner(owner);

        AnimalTreatment animalTreatmentRequest = new AnimalTreatment();
        animalTreatmentRequest.setId(1L);
        animalTreatmentRequest.setPetId(1L);
        animalTreatmentRequest.setMedicine("GENERIC NAME");
        animalTreatmentRequest.setDateIn("GENERIC EMAIL");
        animalTreatmentRequest.setDateOut("GENERIC PHONE Number");
        animalTreatmentRequest.setOwner(owner);


        AnimalTreatmentDTO animalTreatmentDTOResponse = new AnimalTreatmentDTO();
        animalTreatmentDTOResponse.setId(1L);
        animalTreatmentDTOResponse.setPetId(1L);
        animalTreatmentDTOResponse.setMedicine("GENERIC NAME");
        animalTreatmentDTOResponse.setDateIn("GENERIC EMAIL");
        animalTreatmentDTOResponse.setDateOut("GENERIC PHONE Number");
        animalTreatmentDTOResponse.setOwner(owner);

        AnimalTreatment animalTreatment = new AnimalTreatment();
        animalTreatment.setId(1L);
        animalTreatment.setPetId(1L);
        animalTreatment.setMedicine("GENERIC NAME");
        animalTreatment.setDateIn("GENERIC EMAIL");
        animalTreatment.setDateOut("GENERIC PHONE Number");
        animalTreatment.setOwner(owner);

        when(animalTreatmentMapper.animalTreatmentDTOToEntity(any(AnimalTreatmentDTO.class))).thenReturn(animalTreatmentRequest);
        when(animalTreatmentDAO.save(any(AnimalTreatment.class))).thenReturn(animalTreatment);
        when(animalTreatmentMapper.animalTreatmentEntityToDTO(any(AnimalTreatment.class))).thenReturn(animalTreatmentDTOResponse);

        AnimalTreatmentDTO response = animalTreatmentService.addTreatment(animalTreatmentDTORequest);
        assertNotNull(response);
        assertEquals(response, animalTreatmentDTOResponse);
        assertEquals(response.getMedicine(), animalTreatmentDTORequest.getMedicine());

        Mockito.verify(animalTreatmentMapper, times(1)).animalTreatmentDTOToEntity(any(AnimalTreatmentDTO.class));
        Mockito.verify(animalTreatmentDAO, times(1)).save(any(AnimalTreatment.class));
        Mockito.verify(animalTreatmentMapper, times(1)).animalTreatmentEntityToDTO(any(AnimalTreatment.class));
    }

    @Test
    public void selectAnimalTreatmentTest() {

        AnimalTreatmentDTO animalTreatmentDTORequest = new AnimalTreatmentDTO();
        animalTreatmentDTORequest.setId(1L);
        animalTreatmentDTORequest.setPetId(1L);
        animalTreatmentDTORequest.setMedicine("GENERIC NAME");
        animalTreatmentDTORequest.setDateIn("GENERIC EMAIL");
        animalTreatmentDTORequest.setDateOut("GENERIC PHONE Number");
        animalTreatmentDTORequest.setOwner(owner);

        AnimalTreatment animalTreatmentRequest = new AnimalTreatment();
        animalTreatmentRequest.setId(1L);
        animalTreatmentRequest.setPetId(1L);
        animalTreatmentRequest.setMedicine("GENERIC NAME");
        animalTreatmentRequest.setDateIn("GENERIC EMAIL");
        animalTreatmentRequest.setDateOut("GENERIC PHONE Number");
        animalTreatmentRequest.setOwner(owner);


        AnimalTreatmentDTO animalTreatmentDTOResponse = new AnimalTreatmentDTO();
        animalTreatmentDTOResponse.setId(1L);
        animalTreatmentDTOResponse.setPetId(1L);
        animalTreatmentDTOResponse.setMedicine("GENERIC NAME");
        animalTreatmentDTOResponse.setDateIn("GENERIC EMAIL");
        animalTreatmentDTOResponse.setDateOut("GENERIC PHONE Number");
        animalTreatmentDTOResponse.setOwner(owner);

        AnimalTreatment animalTreatment = new AnimalTreatment();
        animalTreatment.setId(1L);
        animalTreatment.setPetId(1L);
        animalTreatment.setMedicine("GENERIC NAME");
        animalTreatment.setDateIn("GENERIC EMAIL");
        animalTreatment.setDateOut("GENERIC PHONE Number");
        animalTreatment.setOwner(owner);


        when(animalTreatmentMapper.animalTreatmentDTOToEntity(any(AnimalTreatmentDTO.class))).thenReturn(animalTreatmentRequest);
        when(animalTreatmentDAO.getById(animalTreatmentRequest.getId())).thenReturn(animalTreatment);
        when(animalTreatmentMapper.animalTreatmentEntityToDTO(any(AnimalTreatment.class))).thenReturn(animalTreatmentDTOResponse);

        AnimalTreatmentDTO response = animalTreatmentService.selectTreatment(animalTreatmentDTORequest.getId());
        assertNotNull(response);
        assertEquals(response, animalTreatmentDTOResponse);
        assertEquals(response.getId(), animalTreatmentDTORequest.getId());

        Mockito.verify(animalTreatmentMapper, times(1)).animalTreatmentDTOToEntity(any(AnimalTreatmentDTO.class));
        Mockito.verify(animalTreatmentDAO, times(1)).getById(animalTreatmentDTORequest.getId());
        Mockito.verify(animalTreatmentMapper, times(1)).animalTreatmentEntityToDTO(any(AnimalTreatment.class));
    }

    @Test(expected = InvalidDataException.class)
    public void updateAnimalTreatment() {

        AnimalTreatmentDTO animalTreatmentDTORequest = new AnimalTreatmentDTO();
        animalTreatmentDTORequest.setId(1L);
        animalTreatmentDTORequest.setPetId(1L);
        animalTreatmentDTORequest.setMedicine("GENERIC NAME");
        animalTreatmentDTORequest.setDateIn("GENERIC EMAIL");
        animalTreatmentDTORequest.setDateOut("GENERIC PHONE Number");
        animalTreatmentDTORequest.setOwner(owner);


        AnimalTreatmentDTO animalTreatmentDTOResponse = new AnimalTreatmentDTO();
        animalTreatmentDTOResponse.setId(1L);
        animalTreatmentDTOResponse.setPetId(1L);
        animalTreatmentDTOResponse.setMedicine("GENERIC NAME");
        animalTreatmentDTOResponse.setDateIn("GENERIC EMAIL");
        animalTreatmentDTOResponse.setDateOut("GENERIC PHONE Number");
        animalTreatmentDTOResponse.setOwner(owner);



        when(animalTreatmentService.editTreatment(animalTreatmentDTORequest)).thenReturn(null);
        AnimalTreatmentDTO response = animalTreatmentService.editTreatment(animalTreatmentDTORequest);
        assertNotNull(response);
        assertNotEquals(animalTreatmentDTOResponse.getMedicine(), response.getMedicine());

    }

    @Test(expected = InvalidDataException.class)
    public void deleteAnimalTreatment() {

        AnimalTreatmentDTO animalTreatmentDTORequest = new AnimalTreatmentDTO();
        animalTreatmentDTORequest.setId(1L);
        animalTreatmentDTORequest.setPetId(1L);
        animalTreatmentDTORequest.setMedicine("GENERIC NAME");
        animalTreatmentDTORequest.setDateIn("GENERIC EMAIL");
        animalTreatmentDTORequest.setDateOut("GENERIC PHONE Number");
        animalTreatmentDTORequest.setOwner(owner);


        when(animalTreatmentService.deleteTreatment(animalTreatmentDTORequest));
        AnimalTreatmentDTO response = animalTreatmentService.deleteTreatment(animalTreatmentDTORequest);
        assertNotNull(response);
        Mockito.verify(animalTreatmentDAO, times(1)).delete((any(AnimalTreatment.class)));
    }
}
