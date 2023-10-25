package com.k1.Parcial.infrastructure.dao;

import com.k1.Parcial.infrastructure.entity.Album;
import com.k1.Parcial.infrastructure.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DaoTrack extends JpaRepository<Track, Long> {


    List<Track> findByAlbumIdAndGenreId(long artistId, long genreId);
}
