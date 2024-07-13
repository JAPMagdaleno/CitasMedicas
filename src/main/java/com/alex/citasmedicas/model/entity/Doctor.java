package com.alex.citasmedicas.model.entity;

import com.alex.citasmedicas.model.dto.DatosRegistroDoctor;
import com.alex.citasmedicas.model.enums.Especialidad;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity(name = "Doctor")
@Table(name = "doctores")
@Data
@RequiredArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @Enumerated(EnumType.STRING)
    @Column(name = "especialidad")
    private Especialidad especialidad;

    @OneToMany(mappedBy = "doctor")
    private List<Citas> citas;

    public Doctor(DatosRegistroDoctor datosRegistroDoctor) {
        this.nombre = datosRegistroDoctor.nombre();
        this.apellidoPaterno = datosRegistroDoctor.apellidoPaterno();
        this.apellidoMaterno = datosRegistroDoctor.apellidoMaterno();
        this.especialidad = datosRegistroDoctor.especialidad();
    }

}
