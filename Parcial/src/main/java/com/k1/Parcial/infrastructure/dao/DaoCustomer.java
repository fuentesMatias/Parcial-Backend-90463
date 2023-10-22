package com.k1.Parcial.infrastructure.dao;

import com.k1.Parcial.infrastructure.entity.Album;
import com.k1.Parcial.infrastructure.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DaoCustomer extends JpaRepository<Customer, Long> {
}
