package com.k1.Parcial.domain.service.serviceInterfaces;

import com.k1.Parcial.infrastructure.entity.MediaType;

import java.util.Optional;

public interface MediaTypesService {
    Optional<MediaType> getById(Long id);
}
