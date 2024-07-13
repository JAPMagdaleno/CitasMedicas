package com.alex.citasmedicas.model.entity;

import com.alex.citasmedicas.model.dto.DatosRegistroConsultorio;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity(name = "Colsultorio")
@Table(name = "consultorios")
@Data
@RequiredArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consultorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="numero_consultorio")
    private String numeroColsultorio;
    @Column(name="numero_piso")
    private String numeroPiso;

    @OneToMany(mappedBy = "consultorio")
    private List<Citas> citas;

    public Consultorio(DatosRegistroConsultorio datosRegistroConsultorio) {
        this.numeroColsultorio = datosRegistroConsultorio.numeroPiso();
        this.numeroPiso = datosRegistroConsultorio.numeroPiso();
    }
}
