package com.globant.vetpatitas.service;

import com.globant.vetpatitas.dao.AppointmentDAO;
import com.globant.vetpatitas.dao.PetDAO;
import com.globant.vetpatitas.dto.AppointmentDTO;
import com.globant.vetpatitas.entity.Appointment;
import com.globant.vetpatitas.entity.Pet;
import com.globant.vetpatitas.exception.DeactivatedPetException;
import com.globant.vetpatitas.exception.NonexistantAppointmentException;
import com.globant.vetpatitas.mapper.AppointmentMapper;
import com.globant.vetpatitas.service.impl.AppointmentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AppointmentServiceImplTest {

    @InjectMocks
    private AppointmentServiceImpl appointmentService;

    @Mock
    private AppointmentDAO appointmentDAO;

    @Mock
    private AppointmentMapper appointmentMapper;

    @Mock
    private PetDAO petDAO;

    @Test
    public void getAppointmentsFromPetId_ExistentPet_OK() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Pet pet = new Pet();
        pet.setId(1L);

        AppointmentDTO appointmentDTORequest = new AppointmentDTO();
        appointmentDTORequest.setId(1L);
        appointmentDTORequest.setPetId(1L);
        appointmentDTORequest.setDate(now);
        appointmentDTORequest.setReason("GenericReason");
        appointmentDTORequest.setNotes("GenericNote");

        Appointment appointmentResponse = new Appointment();
        appointmentResponse.setId(1L);
        appointmentResponse.setPet(pet);
        appointmentResponse.setDate(now);
        appointmentResponse.setReason("GenericReason");
        appointmentResponse.setNotes("GenericNote");

        AppointmentDTO appointmentDTOResponse = new AppointmentDTO();
        appointmentDTOResponse.setId(1L);
        appointmentDTOResponse.setPetId(1L);
        appointmentDTOResponse.setDate(now);
        appointmentDTOResponse.setReason("GenericReason");
        appointmentDTOResponse.setNotes("GenericNote");

        List<Appointment> petAppointmentList = new ArrayList<>();
        petAppointmentList.add(appointmentResponse);

        List<AppointmentDTO> petDTOResponseList = new ArrayList<>();
        petDTOResponseList.add(appointmentDTOResponse);

        when(appointmentDAO.getAppointmentsFromPet(any(Long.class))).thenReturn(petAppointmentList);
        when(appointmentMapper.appointmentEntityToDTO(any(Appointment.class))).thenReturn(appointmentDTOResponse);

        List<AppointmentDTO> petDTOAppointmentList = appointmentService.getAppointmentsFromPetId(pet.getId());
        assertNotNull(petDTOAppointmentList);
        assertEquals(petDTOResponseList, petDTOAppointmentList);

        Mockito.verify(appointmentDAO, times(1)).getAppointmentsFromPet(any(Long.class));
        Mockito.verify(appointmentMapper, times(1)).appointmentEntityToDTO(any(Appointment.class));

    }

    @Test
    public void getAllAppointments_ExistentID_OK() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Pet pet = new Pet();
        pet.setId(1L);

        Appointment appointmentResponse = new Appointment();
        appointmentResponse.setId(1L);
        appointmentResponse.setPet(pet);
        appointmentResponse.setDate(now);
        appointmentResponse.setReason("GenericReason");
        appointmentResponse.setNotes("GenericNote");

        AppointmentDTO appointmentDTOResponse = new AppointmentDTO();
        appointmentDTOResponse.setId(1L);
        appointmentDTOResponse.setPetId(1L);
        appointmentDTOResponse.setDate(now);
        appointmentDTOResponse.setReason("GenericReason");
        appointmentDTOResponse.setNotes("GenericNote");

        List<AppointmentDTO> appointmentDTOListResponse = new ArrayList<>();
        appointmentDTOListResponse.add(appointmentDTOResponse);

        List<Appointment> appointmentListResponse = new ArrayList<>();
        appointmentListResponse.add(appointmentResponse);

        when(appointmentDAO.getAllAppointmentsInDB()).thenReturn(appointmentListResponse);
        when(appointmentMapper.appointmentEntityToDTO(any(Appointment.class))).thenReturn(appointmentDTOResponse);

        List<AppointmentDTO> appointmentDTORequestList = appointmentService.getAllAppointments();
        assertNotNull(appointmentDTORequestList);
        assertEquals(appointmentDTOListResponse, appointmentDTORequestList);
    }

    @Test
    public void getAppointmentFromId_ExistentID_OK() {
        Long id = 1L;
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Pet pet = new Pet();
        pet.setId(1L);

        AppointmentDTO appointmentDTORequest = new AppointmentDTO();
        appointmentDTORequest.setId(1L);
        appointmentDTORequest.setPetId(1L);
        appointmentDTORequest.setDate(now);
        appointmentDTORequest.setReason("GenericReason");
        appointmentDTORequest.setNotes("GenericNote");

        Appointment appointmentResponse = new Appointment();
        appointmentResponse.setId(1L);
        appointmentResponse.setPet(pet);
        appointmentResponse.setDate(now);
        appointmentResponse.setReason("GenericReason");
        appointmentResponse.setNotes("GenericNote");

        AppointmentDTO appointmentDTOResponse = new AppointmentDTO();
        appointmentDTOResponse.setId(1L);
        appointmentDTOResponse.setPetId(1L);
        appointmentDTOResponse.setDate(now);
        appointmentDTOResponse.setReason("GenericReason");

        when(appointmentDAO.getAppointmentById(any(Long.class))).thenReturn(appointmentResponse);
        when(appointmentMapper.appointmentEntityToDTO(any(Appointment.class))).thenReturn(appointmentDTOResponse);

        AppointmentDTO appointmentDTO = appointmentService.getAppointmentFromId(id);
        assertNotNull(appointmentDTO);
        assertEquals(appointmentDTO, appointmentDTOResponse);

        Mockito.verify(appointmentDAO, times(1)).getAppointmentById(any(Long.class));
        Mockito.verify(appointmentMapper, times(1)).appointmentEntityToDTO(any(Appointment.class));

    }

    @Test(expected = NonexistantAppointmentException.class)
    public void getAppointmentFromId_NonexistentID_OK() {
        Long id = 999999L;

        when(appointmentDAO.getAppointmentById(any(Long.class))).thenThrow(NullPointerException.class);
        appointmentService.getAppointmentFromId(id);
        Mockito.verify(appointmentDAO, times(1)).getAppointmentById(any(Long.class));

    }

    @Test(expected = DeactivatedPetException.class)
    public void createAppointment_DeactivatedPet_ThenDeactivatedPetException() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Pet pet = new Pet();
        pet.setId(1L);
        pet.setActive(Boolean.FALSE);

        AppointmentDTO appointmentDTORequest = new AppointmentDTO();
        appointmentDTORequest.setId(1L);
        appointmentDTORequest.setPetId(1L);
        appointmentDTORequest.setDate(now);
        appointmentDTORequest.setReason("GenericReason");
        appointmentDTORequest.setNotes("GenericNote");
        when(petDAO.getPetById(any(Long.class))).thenReturn(pet);
        appointmentService.createAppointment(appointmentDTORequest, pet.getId());
        Mockito.verify(petDAO, times(1)).getPetById(any(Long.class));
    }

    @Test
    public void createAppointment_ActivePet_OK() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Pet pet = new Pet();
        pet.setId(1L);
        pet.setActive(Boolean.TRUE);

        Appointment appointmentRequest = new Appointment();
        appointmentRequest.setId(1L);
        appointmentRequest.setPet(pet);
        appointmentRequest.setDate(now);
        appointmentRequest.setReason("GenericReason");
        appointmentRequest.setNotes("GenericNote");

        Appointment appointmentResponse = new Appointment();
        appointmentResponse.setId(1L);
        appointmentResponse.setPet(pet);
        appointmentResponse.setDate(now);
        appointmentResponse.setReason("GenericReason");
        appointmentResponse.setNotes("GenericNote");

        AppointmentDTO appointmentDTORequest = new AppointmentDTO();
        appointmentDTORequest.setId(1L);
        appointmentDTORequest.setPetId(1L);
        appointmentDTORequest.setDate(now);
        appointmentDTORequest.setReason("GenericReason");
        appointmentDTORequest.setNotes("GenericNote");

        AppointmentDTO appointmentDTOResponse = new AppointmentDTO();
        appointmentDTOResponse.setId(1L);
        appointmentDTOResponse.setPetId(1L);
        appointmentDTOResponse.setDate(now);
        appointmentDTOResponse.setReason("GenericReason");
        appointmentDTOResponse.setNotes("GenericNote");

        when(petDAO.getPetById(any(Long.class))).thenReturn(pet);
        when(appointmentMapper.appointmentDTOToEntity(any(AppointmentDTO.class))).thenReturn(appointmentResponse);
        when(appointmentDAO.save(any(Appointment.class))).thenReturn(appointmentResponse);
        when(appointmentMapper.appointmentEntityToDTO(any(Appointment.class))).thenReturn(appointmentDTOResponse);

        AppointmentDTO appointmentDTO = appointmentService.createAppointment(appointmentDTORequest, pet.getId());
        assertNotNull(appointmentDTO);
        assertEquals(appointmentDTO, appointmentDTOResponse);

        Mockito.verify(petDAO, times(1)).getPetById(any(Long.class));
        Mockito.verify(appointmentMapper, times(1)).appointmentDTOToEntity(any(AppointmentDTO.class));
        Mockito.verify(appointmentDAO, times(1)).save(any(Appointment.class));
        Mockito.verify(appointmentMapper, times(1)).appointmentEntityToDTO(any(Appointment.class));

    }

    @Test
    public void updateAppointment_ValidData_OK() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Pet pet = new Pet();
        pet.setId(1L);
        pet.setActive(Boolean.TRUE);

        Appointment appointmentRequest = new Appointment();
        appointmentRequest.setId(1L);
        appointmentRequest.setPet(pet);
        appointmentRequest.setDate(now);
        appointmentRequest.setReason("GenericReason");
        appointmentRequest.setNotes("GenericNote");

        Appointment appointmentResponse = new Appointment();
        appointmentResponse.setId(1L);
        appointmentResponse.setPet(pet);
        appointmentResponse.setDate(now);
        appointmentResponse.setReason("GenericReason");
        appointmentResponse.setNotes("GenericNote");

        AppointmentDTO appointmentDTORequest = new AppointmentDTO();
        appointmentDTORequest.setId(1L);
        appointmentDTORequest.setPetId(1L);
        appointmentDTORequest.setDate(now);
        appointmentDTORequest.setReason("GenericReason");
        appointmentDTORequest.setNotes("GenericNote");

        AppointmentDTO appointmentDTOResponse = new AppointmentDTO();
        appointmentDTOResponse.setId(1L);
        appointmentDTOResponse.setPetId(1L);
        appointmentDTOResponse.setDate(now);
        appointmentDTOResponse.setReason("GenericReason");
        appointmentDTOResponse.setNotes("GenericNote");

        when(appointmentDAO.getAppointmentById(any(Long.class))).thenReturn(appointmentResponse);
        when(appointmentDAO.save(any(Appointment.class))).thenReturn(appointmentResponse);
        when(appointmentMapper.appointmentEntityToDTO(any(Appointment.class))).thenReturn(appointmentDTOResponse);

        AppointmentDTO appointmentDTO = appointmentService.updateAppointment(appointmentDTORequest, pet.getId());
        assertNotNull(appointmentDTO);
        assertEquals(appointmentDTORequest.getId(), appointmentDTO.getId());
        assertEquals(appointmentDTORequest.getDate(), appointmentDTO.getDate());
        assertEquals(appointmentDTO.getNotes(), appointmentDTO.getNotes());
        assertEquals(appointmentDTO.getReason(), appointmentDTO.getReason());
        assertEquals(appointmentDTO.getPetId(), appointmentDTO.getPetId());

        Mockito.verify(appointmentDAO, times(1)).getAppointmentById(any(Long.class));
        Mockito.verify(appointmentDAO, times(1)).save(any(Appointment.class));
        Mockito.verify(appointmentMapper, times(1)).appointmentEntityToDTO(any(Appointment.class));

    }

    @Test
    public void deleteAppointment_ValidId_OK() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Pet pet = new Pet();
        pet.setId(1L);

        Appointment appointmentResponse = new Appointment();
        appointmentResponse.setId(1L);
        appointmentResponse.setPet(pet);
        appointmentResponse.setDate(now);
        appointmentResponse.setReason("GenericReason");
        appointmentResponse.setNotes("GenericNote");

        Long id = 1L;
        when(appointmentDAO.getAppointmentById(any(Long.class))).thenReturn(appointmentResponse);
        appointmentService.deleteAppointment(id);
        Mockito.verify(appointmentDAO, times(1)).getAppointmentById(any(Long.class));
        Mockito.verify(appointmentDAO, times(1)).delete(any(Appointment.class));
    }

}
