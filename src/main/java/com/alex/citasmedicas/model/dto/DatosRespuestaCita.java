package com.alex.citasmedicas.model.dto;

public record DatosRespuestaCita(
        Long id,
        Long idConsultorio,
        Long idDoctor,
        String horarioConsulta,
        String nombrePaciente
) {}
