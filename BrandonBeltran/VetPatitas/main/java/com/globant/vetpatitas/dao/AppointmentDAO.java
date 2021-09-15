package com.globant.vetpatitas.dao;

import com.globant.vetpatitas.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentDAO extends JpaRepository<Appointment, Long> {

    @Query("SELECT appointment FROM Appointment appointment WHERE appointment.pet.id IN :id")
    List<Appointment> getAppointmentsFromPet(Long id);

    @Query("SELECT appointment FROM Appointment appointment WHERE appointment.id IN :id")
    Appointment getAppointmentById(Long id);

    @Query("SELECT appointment FROM Appointment appointment")
    List<Appointment> getAllAppointmentsInDB();

}
