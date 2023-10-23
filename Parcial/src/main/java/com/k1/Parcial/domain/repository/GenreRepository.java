package com.k1.Parcial.domain.repository;

import com.k1.Parcial.infrastructure.entity.Genre;

import java.util.Optional;

public interface GenreRepository {
    Optional<Genre> getById(Long id);

}
