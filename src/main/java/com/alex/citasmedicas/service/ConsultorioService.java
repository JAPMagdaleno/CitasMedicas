package com.alex.citasmedicas.service;

import com.alex.citasmedicas.model.dto.DatosRegistroConsultorio;
import com.alex.citasmedicas.model.dto.DatosRegistroDoctor;
import com.alex.citasmedicas.model.entity.Consultorio;
import com.alex.citasmedicas.model.entity.Doctor;
import com.alex.citasmedicas.repository.ConsultorioRepo;
import com.alex.citasmedicas.repository.DoctorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsultorioService {

    private final ConsultorioRepo consultorioRepo;

    public Consultorio registrar(DatosRegistroConsultorio datosRegistroConsultorio){
        return consultorioRepo.save(new Consultorio(datosRegistroConsultorio));
    }
}
