package com.globant.vetpatitas.service;

import com.globant.vetpatitas.dto.AppointmentDTO;

import java.util.List;

public interface AppointmentService {
    List<AppointmentDTO> getAppointmentsFromPetId(Long petId);
    List<AppointmentDTO> getAllAppointments();
    AppointmentDTO getAppointmentFromId(Long id);
    AppointmentDTO createAppointment(AppointmentDTO appointmentDTO, Long id);
    AppointmentDTO updateAppointment(AppointmentDTO appointmentDTO, Long id);
    void deleteAppointment(Long id);
}
