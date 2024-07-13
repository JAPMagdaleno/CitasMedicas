package com.alex.citasmedicas.controller;

import com.alex.citasmedicas.model.dto.DatosRegistroConsultorio;
import com.alex.citasmedicas.model.dto.DatosRegistroDoctor;
import com.alex.citasmedicas.model.dto.DatosRespuestaConsultorio;
import com.alex.citasmedicas.model.dto.DatosRespuestaDoctor;
import com.alex.citasmedicas.model.entity.Consultorio;
import com.alex.citasmedicas.model.entity.Doctor;
import com.alex.citasmedicas.service.ConsultorioService;
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
@RequestMapping("/consultorios")
@RequiredArgsConstructor
public class ConsultorioControlador {

    private final ConsultorioService consultorioService;

    @PostMapping("/registro")
    public ResponseEntity<DatosRespuestaConsultorio> registrarConsultorio(@Valid @RequestBody DatosRegistroConsultorio datosRegistroConsultorio, UriComponentsBuilder uriComponentsBuilder){
       Consultorio consultorio = consultorioService.registrar(datosRegistroConsultorio);
        DatosRespuestaConsultorio datosRespuestaConsultorio = new DatosRespuestaConsultorio(
                consultorio.getId(),
                consultorio.getNumeroColsultorio(),
                consultorio.getNumeroPiso());
        URI url = uriComponentsBuilder.path("/consultorios/{id}").buildAndExpand(consultorio.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaConsultorio);
    }


}
