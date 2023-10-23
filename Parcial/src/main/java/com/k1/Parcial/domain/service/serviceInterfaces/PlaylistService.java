package com.k1.Parcial.domain.service.serviceInterfaces;

import com.k1.Parcial.application.request.Playlist.PlaylistRequestDto;
import com.k1.Parcial.infrastructure.entity.Playlist;

import java.util.List;
import java.util.Optional;

public interface PlaylistService {
    List<Playlist> getAll();

    Optional<Playlist> getById(Long id);

    void delete(Long id);

    Optional<Playlist> update(Long id,PlaylistRequestDto entity);

    Playlist save(PlaylistRequestDto entity);

    Playlist addTrackToPlaylist(Long idPlaylist, Long idTrack);
}
