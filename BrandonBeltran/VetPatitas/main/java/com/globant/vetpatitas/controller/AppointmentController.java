package com.globant.vetpatitas.controller;

import com.globant.vetpatitas.dto.AppointmentDTO;
import com.globant.vetpatitas.dto.ResponseDTO;
import com.globant.vetpatitas.service.AppointmentService;
import com.globant.vetpatitas.utils.Constants.ResponseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.globant.vetpatitas.utils.Constants.*;

@RestController
@RequestMapping("vetpatitas")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping(path = "/pet/{id}/addAppointment", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ResponseDTO<AppointmentDTO>> createAppointment(@PathVariable Long id, @RequestBody AppointmentDTO appointmentDTO) {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, APPOINTMENT_ADDED_SUCCESSFULLY, appointmentService.createAppointment(appointmentDTO, id));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping(path = "/pet/{id}/Appointments", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ResponseDTO<List<AppointmentDTO>>> getPetAppointments(@PathVariable Long id) {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, PET_APPOINTMENTS_CONSULTED_SUCCESSFULLY, appointmentService.getAppointmentsFromPetId(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/Appointments", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ResponseDTO<List<AppointmentDTO>>> getAppointment() {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, APPOINTMENTS_CONSULTED_SUCCESSFULLY, appointmentService.getAllAppointments());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/Appointments/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ResponseDTO<AppointmentDTO>> getAppointmentById(@PathVariable Long id) {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, APPOINTMENT_CONSULTED_SUCCESSFULLY, appointmentService.getAppointmentFromId(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping(path = "/Appointments/{id}/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ResponseDTO<AppointmentDTO>> editAppointment(@PathVariable Long id, @RequestBody AppointmentDTO appointmentDTO) {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, APPOINTMENT_UPDATED_SUCCESSFULLY, appointmentService.updateAppointment(appointmentDTO, id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping(path = "/Appointments/{id}/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ResponseDTO> deleteAppointment(@PathVariable Long id){
        appointmentService.deleteAppointment(id);
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, APPOINTMENT_DELETED_SUCCESSFULLY, null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
