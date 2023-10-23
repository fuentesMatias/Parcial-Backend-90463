package com.k1.Parcial.infrastructure.repository;

import com.k1.Parcial.domain.repository.MediaTypeRepository;
import com.k1.Parcial.infrastructure.dao.DaoMediaType;
import com.k1.Parcial.infrastructure.entity.MediaType;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JpaMediaTypeRepository implements MediaTypeRepository {
    private final DaoMediaType daoMediaType;

    public JpaMediaTypeRepository(DaoMediaType daoMediaType) {
        this.daoMediaType = daoMediaType;
    }

    @Override
    public Optional<MediaType> getById(Long id) {
        return daoMediaType.findById(id);
    }
}
