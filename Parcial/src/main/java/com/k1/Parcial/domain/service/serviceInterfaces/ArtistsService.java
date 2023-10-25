package com.k1.Parcial.domain.service.serviceInterfaces;

import com.k1.Parcial.infrastructure.entity.Artist;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface ArtistsService {
    Optional<Artist> getById(Long id);
}
