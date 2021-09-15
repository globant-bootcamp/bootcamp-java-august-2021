package com.globant.vetpatitas.mapper;

import com.globant.vetpatitas.dto.AppointmentDTO;
import com.globant.vetpatitas.entity.Appointment;
import com.globant.vetpatitas.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

    @Autowired
    private PetService petService;

    public Appointment appointmentDTOToEntity(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        appointment.setId(appointmentDTO.getId());
        appointment.setPet(petService.findPet(appointmentDTO.getPetId()));
        appointment.setDate(appointmentDTO.getDate());
        appointment.setReason(appointmentDTO.getReason());
        appointment.setNotes(appointmentDTO.getNotes());
        return appointment;
    }

    public AppointmentDTO appointmentEntityToDTO(Appointment appointment) {
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setId(appointment.getId());
        appointmentDTO.setPetId(appointment.getPet().getId());
        appointmentDTO.setDate(appointment.getDate());
        appointmentDTO.setReason(appointment.getReason());
        appointmentDTO.setNotes(appointment.getNotes());
        return appointmentDTO;
    }
}
