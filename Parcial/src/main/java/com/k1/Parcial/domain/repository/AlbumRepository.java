package com.k1.Parcial.domain.repository;

import com.k1.Parcial.infrastructure.entity.Album;

import java.util.List;
import java.util.Optional;

public interface AlbumRepository {
    // Operaciones crud con optional en las que son un solo objeto

    Optional<Album> getById(Long id);

    List<Album> getAllByArtistId(Long artistId);
}
