package com.k1.Parcial.infrastructure.dao;

import com.k1.Parcial.infrastructure.entity.Album;
import com.k1.Parcial.infrastructure.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DaoEmploye extends JpaRepository<Employe, Long> {
}
