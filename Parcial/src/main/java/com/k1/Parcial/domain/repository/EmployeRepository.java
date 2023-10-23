package com.k1.Parcial.domain.repository;

import com.k1.Parcial.infrastructure.entity.Employe;

import java.util.List;
import java.util.Optional;

public interface EmployeRepository {


    List<Employe> getAll();

    Optional<Employe> getById(Long id);

    void delete(Long id);

    Optional<Employe> update(Employe employe);

    Employe save(Employe employe);

}
