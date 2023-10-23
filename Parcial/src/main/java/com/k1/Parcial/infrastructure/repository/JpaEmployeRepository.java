package com.k1.Parcial.infrastructure.repository;

import com.k1.Parcial.domain.repository.EmployeRepository;
import com.k1.Parcial.infrastructure.dao.DaoEmploye;
import com.k1.Parcial.infrastructure.entity.Employe;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaEmployeRepository implements EmployeRepository {

    private final DaoEmploye daoEmploye;

    public JpaEmployeRepository(DaoEmploye daoEmploye) {
        this.daoEmploye = daoEmploye;
    }
    @Override
    public List<Employe> getAll() {
        return daoEmploye.findAll();
    }

    @Override
    public Optional<Employe> getById(Long id) {
        return Optional.of(daoEmploye.findById(id).orElseThrow());
    }

    @Override
    public void delete(Long id) {
        daoEmploye.deleteById(id);
    }

    @Override
    public Optional<Employe> update(Employe employe) {
        Optional<Employe> employeToUpdate = daoEmploye.findById(employe.getId());
        if (employeToUpdate.isPresent()) {
            employeToUpdate.get().setFirstName(employe.getFirstName());
            employeToUpdate.get().setLastName(employe.getLastName());
            employeToUpdate.get().setTitle(employe.getTitle());
            employeToUpdate.get().setBirthDate(employe.getBirthDate());
            employeToUpdate.get().setHireDate(employe.getHireDate());
            employeToUpdate.get().setAddress(employe.getAddress());
            employeToUpdate.get().setCity(employe.getCity());
            employeToUpdate.get().setState(employe.getState());
            employeToUpdate.get().setCountry(employe.getCountry());
            employeToUpdate.get().setPostalCode(employe.getPostalCode());
            employeToUpdate.get().setPhone(employe.getPhone());
            employeToUpdate.get().setFax(employe.getFax());
            employeToUpdate.get().setEmail(employe.getEmail());
            employeToUpdate.get().setReportsTo(employe.getReportsTo());
            daoEmploye.save(employeToUpdate.get());
        }
        return employeToUpdate;
    }

    @Override
    public Employe save(Employe employe) {
        return daoEmploye.save(employe);
    }
}
