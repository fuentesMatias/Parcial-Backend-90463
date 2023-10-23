package com.k1.Parcial.domain.service.serviceInterfaces;

import com.k1.Parcial.application.request.Track.TrackRequestDto;
import com.k1.Parcial.infrastructure.entity.Track;

import java.util.List;
import java.util.Optional;

public interface TrackService {
    List<Track> getAll();

    Optional<Track> getById(Long id);

    void delete(Long id);

    Optional<Track> update(Long id, TrackRequestDto entity);
    Track save(TrackRequestDto entity);
}