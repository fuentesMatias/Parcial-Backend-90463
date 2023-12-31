package com.k1.Parcial.domain.repository;

import com.k1.Parcial.application.request.Playlist.PlaylistRequestDto;
import com.k1.Parcial.infrastructure.entity.Playlist;

import java.util.List;
import java.util.Optional;

public interface PlaylistRepository {

    List<Playlist> getAll();

    Optional<Playlist> getById(Long id);

    void delete(Long id);

    Optional<Playlist> update(Long id,Playlist playlist);

    Playlist save(Playlist playlist);

}
