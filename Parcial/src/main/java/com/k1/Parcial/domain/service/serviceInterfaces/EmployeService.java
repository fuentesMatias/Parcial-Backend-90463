package com.k1.Parcial.domain.service.serviceInterfaces;

import com.k1.Parcial.infrastructure.entity.Employe;

import java.util.List;
import java.util.Optional;

public interface EmployeService {
    List<Employe> getAll();
    Optional<Employe> getById(Long id);

    void delete(Long id);

    Optional<Employe> update(Employe entity);

    Employe save(Employe entity);
}
