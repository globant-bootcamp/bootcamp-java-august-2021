package com.globant.vetpatitas.service.impl;

import com.globant.vetpatitas.dao.AppointmentDAO;
import com.globant.vetpatitas.dao.PetDAO;
import com.globant.vetpatitas.dto.AppointmentDTO;
import com.globant.vetpatitas.entity.Appointment;
import com.globant.vetpatitas.exception.DeactivatedPetException;
import com.globant.vetpatitas.exception.NonexistantAppointmentException;
import com.globant.vetpatitas.mapper.AppointmentMapper;
import com.globant.vetpatitas.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.globant.vetpatitas.utils.Constants.DEACTIVATED_PET_ERROR;
import static com.globant.vetpatitas.utils.Constants.NONEXISTENT_APPOINTMENT;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Autowired
    private AppointmentDAO appointmentDAO;

    @Autowired
    private PetDAO petDAO;


    @Override
    public List<AppointmentDTO> getAppointmentsFromPetId(Long petId) {
        return EntityListToDTOList(appointmentDAO.getAppointmentsFromPet(petId));
    }

    @Override
    public List<AppointmentDTO> getAllAppointments() {
        return EntityListToDTOList(appointmentDAO.getAllAppointmentsInDB());
    }

    @Override
    public AppointmentDTO getAppointmentFromId(Long id) {
        AppointmentDTO appointmentDTO;
        try{
            appointmentDTO = appointmentMapper.appointmentEntityToDTO(appointmentDAO.getAppointmentById(id));
        } catch (NullPointerException ibe) {
            throw new NonexistantAppointmentException(NONEXISTENT_APPOINTMENT);
        }
        return appointmentDTO;
    }

    @Override
    public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO, Long petId) {
        if (!petDAO.getPetById(petId).getActive()) {
            throw new DeactivatedPetException(DEACTIVATED_PET_ERROR);
        }
        appointmentDTO.setPetId(petId);
        return appointmentMapper.appointmentEntityToDTO(appointmentDAO.save(appointmentMapper.appointmentDTOToEntity(appointmentDTO)));
    }

    @Override
    public AppointmentDTO updateAppointment(AppointmentDTO appointmentDTO, Long id) {
        Appointment appointment = appointmentDAO.getAppointmentById(id);
        appointment.setNotes(appointmentDTO.getNotes());
        appointment.setReason(appointmentDTO.getReason());
        appointment.setDate(appointmentDTO.getDate());
        appointmentDAO.save(appointment);
        return appointmentMapper.appointmentEntityToDTO(appointment);
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentDAO.delete(appointmentDAO.getAppointmentById(id));
    }


    private List<AppointmentDTO> EntityListToDTOList(List<Appointment> appointmentList) {
        List<AppointmentDTO> appointmentDTOList = new ArrayList<>();
        for (Appointment appointment : appointmentList) {
            appointmentDTOList.add(appointmentMapper.appointmentEntityToDTO(appointment));
        }
        return appointmentDTOList;
    }
}
