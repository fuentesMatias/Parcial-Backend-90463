package com.k1.Parcial.domain.service.servicesImpl;

import com.k1.Parcial.application.request.Playlist.PlaylistRequestDto;
import com.k1.Parcial.domain.repository.PlaylistRepository;
import com.k1.Parcial.domain.service.serviceInterfaces.PlaylistService;
import com.k1.Parcial.domain.service.serviceInterfaces.TrackService;
import com.k1.Parcial.infrastructure.entity.Playlist;
import com.k1.Parcial.infrastructure.entity.Track;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final TrackService trackService;

    public PlaylistServiceImpl(PlaylistRepository playlistRepository, TrackService trackService) {
        this.playlistRepository = playlistRepository;
        this.trackService = trackService;
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
    public Optional<Playlist> update(Long id,PlaylistRequestDto playlistRequestDto) {

        Playlist playlist = new Playlist(playlistRequestDto);


        return Optional.of(playlistRepository.update(id,playlist).orElseThrow());
    }

    @Override
    public Playlist save(PlaylistRequestDto playlistDto) {

        Playlist playlist = new Playlist(playlistDto);

        return playlistRepository.save(playlist);
    }

    @Override
    public Playlist addTrackToPlaylist(Long idPlaylist, Long idTrack) {
        Track track = trackService.getById(idTrack).orElseThrow();

        Playlist playlist = playlistRepository.getById(idPlaylist).orElseThrow();

        playlist.addTrack(track);

        return playlistRepository.update(idPlaylist,playlist).orElseThrow();
    }
}
