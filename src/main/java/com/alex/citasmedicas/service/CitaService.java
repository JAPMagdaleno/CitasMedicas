package com.alex.citasmedicas.service;

import com.alex.citasmedicas.model.dto.DatosRegistroCita;
import com.alex.citasmedicas.model.dto.DatosRegistroDoctor;
import com.alex.citasmedicas.model.entity.Citas;
import com.alex.citasmedicas.model.entity.Doctor;
import com.alex.citasmedicas.repository.CitaRepo;
import com.alex.citasmedicas.repository.DoctorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CitaService {
    private final CitaRepo citaRepo;

    public Citas registrar(DatosRegistroCita datosRegistroCita){
        return citaRepo.save(new Citas(datosRegistroCita));
    }
}
