package com.k1.Parcial.domain.service.servicesImpl;

import com.k1.Parcial.domain.repository.InvoiceRepository;
import com.k1.Parcial.domain.repository.PlaylistRepository;
import com.k1.Parcial.domain.service.serviceInterfaces.InvoiceService;
import com.k1.Parcial.domain.service.serviceInterfaces.PlaylistService;
import com.k1.Parcial.infrastructure.entity.Invoice;
import com.k1.Parcial.infrastructure.entity.Playlist;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;

    public PlaylistServiceImpl(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public List<Playlist> getAll() {
        return playlistRepository.getAll();
    }

    @Override
    public Optional<Playlist> getById(Long id) {
        return Optional.of(playlistRepository.getById(id).orElseThrow());
    }

    @Override
    public void delete(Long id) {
        playlistRepository.delete(id);
    }

    @Override
    public Optional<Playlist> update(Playlist playlist) {
        return Optional.of(playlistRepository.update(playlist).orElseThrow());
    }

    @Override
    public Playlist save(Playlist playlist) {
        return playlistRepository.save(playlist);
    }
}
