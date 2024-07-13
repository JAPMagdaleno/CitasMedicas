package com.alex.citasmedicas.model.dto;

public record DatosRespuestaDoctor(
        Long id,
        String nombre,
        String apellidoPaterno,
        String apellidoMaterno,
        String especialidad
) {
}
