package com.k1.Parcial.application.controller;


import com.k1.Parcial.infrastructure.entity.Playlist;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.k1.Parcial.domain.service.serviceInterfaces.PlaylistService;

@RestController
@RequestMapping("/api/playList")
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping
    public ResponseEntity<?> getAllPlaylists(){
        try {
            return ResponseEntity.ok().body(playlistService.getAll());
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPlaylistById(@PathVariable("id") Long id){
        try {
            return ResponseEntity.status(200).body(playlistService.getById(id).get());
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlaylist(@PathVariable("id") Long id){
        try {
            playlistService.delete(id);
            return ResponseEntity.ok().body("Playlist deleted");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> registrarPlaylist(@RequestBody Playlist playlist){
        try {
            return ResponseEntity.ok().body(playlistService.save(playlist));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> actualizarPlaylist(@RequestBody Playlist playlist){
        try {
            return ResponseEntity.ok().body(playlistService.update(playlist).get());
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }



}
