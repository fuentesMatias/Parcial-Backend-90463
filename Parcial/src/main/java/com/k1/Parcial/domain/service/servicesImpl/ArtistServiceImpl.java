package com.k1.Parcial.domain.service.servicesImpl;

import com.k1.Parcial.domain.repository.ArtistRepository;
import com.k1.Parcial.domain.service.serviceInterfaces.ArtistsService;
import com.k1.Parcial.infrastructure.entity.Artist;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistsService {

    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }
    @Override
    public Optional<Artist> getById(Long id) {
        return artistRepository.getArtist(id);
    }
}
