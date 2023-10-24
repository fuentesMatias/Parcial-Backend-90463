package com.k1.Parcial.application.controller;


import com.k1.Parcial.application.request.Playlist.PlaylistRequestDto;
import com.k1.Parcial.application.response.Playlist.PlaylistResponseDto;
import com.k1.Parcial.infrastructure.entity.Playlist;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.k1.Parcial.domain.service.serviceInterfaces.PlaylistService;

import java.util.List;

@RestController
@RequestMapping("/api/playlist")
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping
    public ResponseEntity<?> getAllPlaylists(){
        try {
            List<PlaylistResponseDto> responseDTOList = playlistService.getAll().stream().map(PlaylistResponseDto::new).toList();
            return ResponseEntity.ok().body(responseDTOList);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPlaylistById(@PathVariable("id") @Positive Long id){
        try {
            PlaylistResponseDto responseDTO = new PlaylistResponseDto(playlistService.getById(id).get());
            return ResponseEntity.status(200).body(responseDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlaylist(@PathVariable("id") @Positive Long id){
        try {
            playlistService.delete(id);
            return ResponseEntity.ok().body("Playlist deleted");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> registrarPlaylist(@RequestBody PlaylistRequestDto playlistRequestDto) {
        try {
            PlaylistResponseDto responseDto = playlistService.save(playlistRequestDto).toDto();
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPlaylist(@PathVariable("id") @Positive Long id, @RequestBody PlaylistRequestDto playlistRequestDto){
        try {
            return ResponseEntity.ok().body(playlistService.update(id,playlistRequestDto).get().toDto());
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

}
