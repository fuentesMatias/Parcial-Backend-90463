package com.k1.Parcial.domain.service.servicesImpl;

import com.k1.Parcial.domain.repository.GenreRepository;
import com.k1.Parcial.domain.service.serviceInterfaces.GenreService;
import com.k1.Parcial.infrastructure.entity.Genre;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenreServiceIml implements GenreService {
    private final GenreRepository genreRepository;

    public GenreServiceIml(GenreRepository genreRepository) {

        this.genreRepository = genreRepository;
    }

    @Override
    public Optional<Genre> getById(Long id) {
        return genreRepository.getById(id);
    }
}
