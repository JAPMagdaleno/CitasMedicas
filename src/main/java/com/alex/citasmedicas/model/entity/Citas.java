package com.alex.citasmedicas.model.entity;

import com.alex.citasmedicas.model.dto.DatosRegistroCita;
import com.alex.citasmedicas.model.dto.DatosRegistroDoctor;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Entity(name = "Cita")
@Table(name = "Citas")
@Data
@RequiredArgsConstructor
@EqualsAndHashCode(of = "id")
public class Citas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "consultorio_id", referencedColumnName = "id")
    private Consultorio consultorio;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;

    String horarioConsulta;
    String nombrePaciente;

    public Citas(DatosRegistroCita datosRegistroCita) {
        this.horarioConsulta = datosRegistroCita.horarioConsulta();
        this.nombrePaciente = datosRegistroCita.nombrePaciente();
    }
}
