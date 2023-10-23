package com.k1.Parcial.infrastructure.repository;

import com.k1.Parcial.domain.repository.CustomerRepository;
import com.k1.Parcial.domain.repository.PlaylistRepository;
import com.k1.Parcial.infrastructure.dao.DaoCustomer;
import com.k1.Parcial.infrastructure.dao.DaoPlaylist;
import com.k1.Parcial.infrastructure.entity.Customer;
import com.k1.Parcial.infrastructure.entity.Playlist;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class JpaPlaylistRepository implements PlaylistRepository {

    private final DaoPlaylist daoPlaylist;

    public JpaPlaylistRepository(DaoPlaylist daoPlaylist) {
        this.daoPlaylist = daoPlaylist;
    }
    @Override
    public List<Playlist> getAll() {
        return daoPlaylist.findAll();
    }
    @Override
    public Optional<Playlist> getById(Long id) {
        return daoPlaylist.findById(id);
    }
    @Override
    public void delete(Long id) {
        daoPlaylist.deleteById(id);
    }
    @Override
    public Optional<Playlist> update(Long id,Playlist playlist) {
        Optional<Playlist> playlistToUpdate = daoPlaylist.findById(id);

        if (playlistToUpdate.isPresent()) {
            playlistToUpdate.get().setName(playlist.getName());
            daoPlaylist.save(playlistToUpdate.get());
        }
        return playlistToUpdate;
    }
    @Override
    public Playlist save(Playlist playlist) {
        return daoPlaylist.save(playlist);
    }


}
