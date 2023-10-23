package com.k1.Parcial.domain.service.serviceInterfaces;

import com.k1.Parcial.infrastructure.entity.Playlist;

import java.util.List;
import java.util.Optional;

public interface PlaylistService {
    List<Playlist> getAll();

    Optional<Playlist> getById(Long id);

    void delete(Long id);

    Optional<Playlist> update(Playlist entity);

    Playlist save(Playlist entity);

}
