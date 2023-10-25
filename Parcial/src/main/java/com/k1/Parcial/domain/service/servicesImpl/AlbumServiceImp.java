package com.k1.Parcial.domain.service.servicesImpl;

import com.k1.Parcial.domain.repository.AlbumRepository;
import com.k1.Parcial.domain.service.serviceInterfaces.AlbumService;
import com.k1.Parcial.infrastructure.entity.Album;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImp implements AlbumService {
    private final AlbumRepository albumRepository;

    public AlbumServiceImp(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> getAll() {
        return null;
    }

    @Override
    public Optional<Album> getById(Long id) {
        return Optional.of(albumRepository.getById(id).orElseThrow());
    }

    @Override
    public List<Album> getAllByArtistId(Long artistId) {
        return albumRepository.getAllByArtistId(artistId);
    }
}
