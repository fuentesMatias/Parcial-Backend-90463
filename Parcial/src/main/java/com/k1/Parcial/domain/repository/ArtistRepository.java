package com.k1.Parcial.domain.repository;

import com.k1.Parcial.infrastructure.entity.Artist;

import java.util.Optional;

public interface ArtistRepository {
    Optional<Artist> getArtist(Long id);
}
