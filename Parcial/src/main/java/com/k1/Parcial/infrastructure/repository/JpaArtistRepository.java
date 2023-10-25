package com.k1.Parcial.infrastructure.repository;

import com.k1.Parcial.domain.repository.ArtistRepository;
import com.k1.Parcial.infrastructure.dao.DaoArtist;
import com.k1.Parcial.infrastructure.entity.Artist;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JpaArtistRepository implements ArtistRepository {

    private final DaoArtist daoArtist;

    public JpaArtistRepository(DaoArtist daoArtist) {
        this.daoArtist = daoArtist;
    }
    @Override
    public Optional<Artist> getArtist(Long id) {
        return daoArtist.findById(id);
    }
}
