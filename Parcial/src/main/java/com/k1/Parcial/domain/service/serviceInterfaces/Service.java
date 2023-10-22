package com.k1.Parcial.domain.service.serviceInterfaces;

import com.k1.Parcial.infrastructure.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface Service <T, ID>{
    List<T> getAll();

    Optional<T> getById(ID id);

    void delete(ID id);

    Optional<T> update(T entity);

    T save(T entity);
}
