package com.k1.Parcial.infrastructure.repository;

import com.k1.Parcial.domain.repository.GenreRepository;
import com.k1.Parcial.infrastructure.dao.DaoGenre;
import com.k1.Parcial.infrastructure.entity.Genre;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JpaGenreRepository implements GenreRepository {
    private final DaoGenre daoGenre;

    public JpaGenreRepository(DaoGenre daoGenre) {
        this.daoGenre = daoGenre;
    }

    @Override
    public Optional<Genre> getById(Long id) {
        return daoGenre.findById(id);
    }
}
