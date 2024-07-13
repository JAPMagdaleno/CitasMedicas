package com.alex.citasmedicas.repository;

import com.alex.citasmedicas.model.entity.Citas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepo extends JpaRepository<Citas,Long> {
}
