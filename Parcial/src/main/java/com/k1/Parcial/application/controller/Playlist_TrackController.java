package com.k1.Parcial.application.controller;


import com.k1.Parcial.domain.service.serviceInterfaces.PlaylistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/playlistTrack")
public class Playlist_TrackController {

    private final PlaylistService playlistService;

    public Playlist_TrackController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }


    @PostMapping("/addTrack/{idPlaylist}/{idTrack}")
    public ResponseEntity<?> addTrackToPlaylist(@PathVariable("idPlaylist") Long idPlaylist, @PathVariable("idTrack") Long idTrack){
        try {
            return ResponseEntity.ok().body(playlistService.addTrackToPlaylist(idPlaylist, idTrack).toDto());
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }


}
