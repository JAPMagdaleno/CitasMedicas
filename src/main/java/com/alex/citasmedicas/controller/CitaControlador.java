package com.alex.citasmedicas.controller;

import com.alex.citasmedicas.model.dto.DatosRegistroCita;
import com.alex.citasmedicas.model.dto.DatosRespuestaCita;
import com.alex.citasmedicas.model.entity.Citas;
import com.alex.citasmedicas.service.CitaService;
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
@RequestMapping("/citas")
@RequiredArgsConstructor
public class CitaControlador {

    private final CitaService citaService;

    @PostMapping("/registro")
    public ResponseEntity<DatosRespuestaCita> registrarCita(@Valid @RequestBody DatosRegistroCita datosRegistroCita, UriComponentsBuilder uriComponentsBuilder) {
        Citas cita = citaService.registrar(datosRegistroCita);
        DatosRespuestaCita datosRespuestaCita = new DatosRespuestaCita(
                cita.getId(),
                cita.getConsultorio().getId(),
                cita.getDoctor().getId(),
                cita.getHorarioConsulta(),
                cita.getNombrePaciente()
        );
        URI url = uriComponentsBuilder.path("/citas/{id}").buildAndExpand(cita.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaCita);
    }
}
