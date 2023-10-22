package com.k1.Parcial.domain.service.servicesImpl;


import com.k1.Parcial.domain.repository.TrackRepository;
import com.k1.Parcial.domain.service.serviceInterfaces.TrackService;
import com.k1.Parcial.infrastructure.entity.Track;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {

    private final TrackRepository trackRepository;

    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
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
    public void delete(Long aLong) {
        trackRepository.delete(aLong);
    }

    @Override
    public Optional<Track> update(Track entity) {
        return Optional.of(trackRepository.update(entity).orElseThrow());
    }

    @Override
    public Track save(Track entity) {
        return trackRepository.save(entity);
    }
}
