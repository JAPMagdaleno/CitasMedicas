package com.alex.citasmedicas.repository;

import com.alex.citasmedicas.model.entity.Consultorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultorioRepo extends JpaRepository<Consultorio, Long> {
}
