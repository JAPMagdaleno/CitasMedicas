package com.alex.citasmedicas.service;

import com.alex.citasmedicas.model.dto.DatosRegistroDoctor;
import com.alex.citasmedicas.model.entity.Doctor;
import com.alex.citasmedicas.repository.DoctorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepo doctorRepo;

    public Doctor registrar(DatosRegistroDoctor datosRegistroDoctor){
        return doctorRepo.save(new Doctor(datosRegistroDoctor));
    }
}
