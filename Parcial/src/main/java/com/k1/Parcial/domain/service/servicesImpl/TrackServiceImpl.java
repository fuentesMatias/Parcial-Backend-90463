package com.k1.Parcial.domain.service.servicesImpl;


import com.k1.Parcial.application.request.Track.TrackRequestDto;
import com.k1.Parcial.domain.repository.TrackRepository;
import com.k1.Parcial.domain.service.serviceInterfaces.AlbumService;
import com.k1.Parcial.domain.service.serviceInterfaces.GenreService;
import com.k1.Parcial.domain.service.serviceInterfaces.MediaTypesService;
import com.k1.Parcial.domain.service.serviceInterfaces.TrackService;
import com.k1.Parcial.infrastructure.entity.Album;
import com.k1.Parcial.infrastructure.entity.Genre;
import com.k1.Parcial.infrastructure.entity.MediaType;
import com.k1.Parcial.infrastructure.entity.Track;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {

    private final TrackRepository trackRepository;
    private final AlbumService albumService;
    private final GenreService genreService;
    private final MediaTypesService mediaTypeService;


    public TrackServiceImpl(TrackRepository trackRepository, AlbumService albumService, GenreService genreService, MediaTypesService mediaTypeService) {
        this.trackRepository = trackRepository;
        this.albumService = albumService;
        this.genreService = genreService;
        this.mediaTypeService = mediaTypeService;
    }

    @Override
    public List<Track> getAll() {
        return trackRepository.getAll();
    }

    @Override
    public Optional<Track> getById(Long aLong) {
        return Optional.of(trackRepository.getById(aLong).orElseThrow());
    }

    @Override
    public Track save(TrackRequestDto entity) {
        Genre genre = genreService.getById(entity.getGenreId()).orElseThrow();
        MediaType mediaType = mediaTypeService.getById(entity.getMediaTypeId()).orElseThrow();
        Album album = albumService.getById(entity.getAlbumId()).orElseThrow();
        Track track = new Track(entity,album,genre,mediaType);
        return trackRepository.save(track);
    }

    @Override
    public void delete(Long aLong) {
        trackRepository.delete(aLong);
    }

    @Override
    public Optional<Track> update(Long id, TrackRequestDto trackRequestDto) {
        Genre genre = null;
        MediaType mediaType = null;
        Album album = null;

        if (trackRequestDto.getGenreId() != 0) {
            genre = genreService.getById(trackRequestDto.getGenreId()).orElseThrow();
        }
        if (trackRequestDto.getMediaTypeId() != 0) {
            mediaType = mediaTypeService.getById(trackRequestDto.getMediaTypeId()).orElseThrow();
        }
        if (trackRequestDto.getAlbumId() != 0) {
            album = albumService.getById(trackRequestDto.getAlbumId()).orElseThrow();
        }
        Track track = new Track(trackRequestDto, album, genre, mediaType);
        return trackRepository.update(id, track);
    }
}
