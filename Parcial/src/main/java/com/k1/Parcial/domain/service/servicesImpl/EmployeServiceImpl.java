package com.k1.Parcial.domain.service.servicesImpl;


import com.k1.Parcial.domain.repository.EmployeRepository;
import com.k1.Parcial.infrastructure.entity.Employe;
import org.springframework.stereotype.Service;
import com.k1.Parcial.domain.service.serviceInterfaces.EmployeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeServiceImpl implements EmployeService {

    private final EmployeRepository employeRepository;

    public EmployeServiceImpl(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    @Override
    public List<Employe> getAll() {
        return employeRepository.getAll();
    }

    @Override
    public Optional<Employe> getById(Long aLong) {
        return Optional.of(employeRepository.getById(aLong).orElseThrow());
    }

    @Override
    public void delete(Long aLong) {
        employeRepository.delete(aLong);
    }

    @Override
    public Optional<Employe> update(Employe entity) {
        return Optional.of(employeRepository.update(entity).orElseThrow());
    }

    @Override
    public Employe save(Employe entity) {
        return null;
    }
}
