package com.alex.citasmedicas.model.dto;

public record DatosRegistroCita(
        Long idConsultorio,
        Long idDoctor,
        String horarioConsulta,
        String nombrePaciente
) {
}
