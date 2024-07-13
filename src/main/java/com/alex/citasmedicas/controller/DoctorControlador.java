package com.alex.citasmedicas.controller;

import com.alex.citasmedicas.model.dto.DatosRegistroDoctor;
import com.alex.citasmedicas.model.dto.DatosRespuestaDoctor;
import com.alex.citasmedicas.model.entity.Doctor;
import com.alex.citasmedicas.service.DoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/doctores")
@RequiredArgsConstructor
public class DoctorControlador {
private final DoctorService doctorService;
    //Create
    @PostMapping("/registro")
    public ResponseEntity<DatosRespuestaDoctor> registrarDoctor(@Valid @RequestBody DatosRegistroDoctor datosRegistroDoctor, UriComponentsBuilder uriComponentsBuilder){
        Doctor doctor = doctorService.registrar(datosRegistroDoctor);
        DatosRespuestaDoctor datosRespuestaDoctor = new DatosRespuestaDoctor(
                doctor.getId(),
                doctor.getNombre(),
                doctor.getApellidoPaterno(),
                doctor.getApellidoMaterno(),
                doctor.getEspecialidad().toString());
        URI url = uriComponentsBuilder.path("/doctores/{id}").buildAndExpand(doctor.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaDoctor);
    }

}
