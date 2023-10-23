package com.k1.Parcial.domain.service.servicesImpl;

import com.k1.Parcial.domain.repository.MediaTypeRepository;
import com.k1.Parcial.domain.service.serviceInterfaces.MediaTypesService;
import com.k1.Parcial.infrastructure.entity.MediaType;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MediaTypeServiceImp implements MediaTypesService {
    private final MediaTypeRepository mediaTypeRepository;

    public MediaTypeServiceImp(MediaTypeRepository mediaTypeRepository) {
        this.mediaTypeRepository = mediaTypeRepository;
    }

    @Override
    public Optional<MediaType> getById(Long id) {
        return mediaTypeRepository.getById(id);
    }
}
