package com.k1.Parcial.infrastructure.repository;

import com.k1.Parcial.domain.repository.CustomerRepository;
import com.k1.Parcial.domain.repository.TrackRepository;
import com.k1.Parcial.infrastructure.dao.DaoCustomer;
import com.k1.Parcial.infrastructure.dao.DaoTrack;
import com.k1.Parcial.infrastructure.entity.Customer;
import com.k1.Parcial.infrastructure.entity.Track;
import org.springframework.stereotype.Component;

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
    public Optional<Track> update(Long id,Track track) {

        Optional<Track> trackToUpdate = daoTrack.findById(id);

        if (trackToUpdate.isPresent()) {
            trackToUpdate.get().setName(track.getName());
            trackToUpdate.get().setComposer(track.getComposer());
            trackToUpdate.get().setMilliseconds(track.getMilliseconds());
            trackToUpdate.get().setBytes(track.getBytes());
            trackToUpdate.get().setUnitPrice(track.getUnitPrice());
            trackToUpdate.get().setAlbum(track.getAlbum());
            trackToUpdate.get().setGenre(track.getGenre());
            trackToUpdate.get().setMediaType(track.getMediaType());
            daoTrack.save(trackToUpdate.get());
        }
        return trackToUpdate;
    }

    @Override
    public Track save(Track track) {
        return daoTrack.save(track);
    }
}
