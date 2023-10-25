package com.k1.Parcial.infrastructure.repository;

import com.k1.Parcial.domain.repository.CustomerRepository;
import com.k1.Parcial.domain.repository.TrackRepository;
import com.k1.Parcial.domain.service.servicesImpl.MetodosComunes;
import com.k1.Parcial.infrastructure.dao.DaoCustomer;
import com.k1.Parcial.infrastructure.dao.DaoTrack;
import com.k1.Parcial.infrastructure.entity.Customer;
import com.k1.Parcial.infrastructure.entity.Track;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;


@Component
public class JpaTrackRepository implements TrackRepository {

    private final DaoTrack daoTrack;

    public JpaTrackRepository(DaoTrack daoTrack) {

        this.daoTrack = daoTrack;
    }

    @Override
    public List<Track> getAll() {

        return daoTrack.findAll();
    }

    @Override
    public Optional<Track> getById(Long id) {
        //devuelve un optional de un track
        return daoTrack.findById(id);
    }

    @Override
    public void delete(Long id) {
        daoTrack.deleteById(id);
    }

    @Override
    public Optional<Track> update(Long id, Track trackNewData) {

        Optional<Track> trackToUpdate = daoTrack.findById(id);

        if (trackToUpdate.isPresent()) {
            Track updateTrack = MetodosComunes.noUpdateToFieldsNull(trackNewData,trackToUpdate.get());
            daoTrack.save(updateTrack);
        }
        return trackToUpdate;
    }


    @Override
    public Track save(Track track) {
        return daoTrack.save(track);
    }

    @Override
    public List<Track> getTrackByAlbumIdAndGenreId(long albumId, long genreId) {
        //daoTrack.findByAlbumIdAndGenreId(albumId,genreId);
        return daoTrack.findByAlbumIdAndGenreId(albumId,genreId);
    }
}
