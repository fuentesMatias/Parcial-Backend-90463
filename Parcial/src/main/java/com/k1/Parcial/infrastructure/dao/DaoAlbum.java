package com.k1.Parcial.infrastructure.dao;

import com.k1.Parcial.infrastructure.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface DaoAlbum extends JpaRepository<Album, Long> {

    List<Album> findAllByArtistId(Long artistId);
}
