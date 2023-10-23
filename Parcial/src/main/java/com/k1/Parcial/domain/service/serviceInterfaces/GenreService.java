package com.k1.Parcial.domain.service.serviceInterfaces;

import com.k1.Parcial.infrastructure.entity.Genre;

import java.util.Optional;

public interface GenreService {
    Optional<Genre> getById(Long id);
}
