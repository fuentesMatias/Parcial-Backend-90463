package com.k1.Parcial.domain.service.serviceInterfaces;

import com.k1.Parcial.infrastructure.entity.Album;

import java.util.List;
import java.util.Optional;

public interface AlbumService {
    List<Album> getAll();

    Optional<Album> getById(Long id);

}
