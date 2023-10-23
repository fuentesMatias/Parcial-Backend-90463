package com.k1.Parcial.infrastructure.repository;

import com.k1.Parcial.domain.repository.AlbumRepository;
import com.k1.Parcial.infrastructure.dao.DaoAlbum;
import com.k1.Parcial.infrastructure.entity.Album;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JpaAlbumRepository implements AlbumRepository {
    private final DaoAlbum daoAlbum;

    public JpaAlbumRepository(DaoAlbum daoAlbum) {
        this.daoAlbum = daoAlbum;
    }

    @Override
    public Optional<Album> getById(Long id) {
        return daoAlbum.findById(id);
    }
}
