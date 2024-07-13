package com.alex.citasmedicas.model.dto;

import com.alex.citasmedicas.model.enums.Especialidad;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroDoctor(
        @NotBlank
        String nombre,

        @NotBlank
        String apellidoPaterno,

        @NotBlank
        String apellidoMaterno,

        @NotNull
        Especialidad especialidad
) {
}
