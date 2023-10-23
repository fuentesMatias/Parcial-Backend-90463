package com.k1.Parcial.domain.repository;


import com.k1.Parcial.infrastructure.entity.Track;

import java.util.List;
import java.util.Optional;

public interface TrackRepository {

    List<Track> getAll();

    Optional<Track> getById(Long id);

    void delete(Long id);

    Optional<Track> update(Long id,Track track);

    Track save(Track track);


}
