package com.k1.Parcial.application.controller;


import com.k1.Parcial.application.request.Track.TrackRequestDto;
import com.k1.Parcial.application.response.Track.TrackResponseByArtistDto;
import com.k1.Parcial.application.response.Track.TrackResponseDto;
import com.k1.Parcial.domain.service.serviceInterfaces.TrackService;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/track")
public class TrackController {

    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping
    public ResponseEntity<?> getAllTracks(){
        try {
            List<TrackResponseDto> tracks = trackService.getAll().stream().map(TrackResponseDto::new).toList();
            return ResponseEntity.ok().body(tracks);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable("id")@Positive Long id){
        try {
            TrackResponseDto tack = new TrackResponseDto(trackService.getById(id).get());
            return ResponseEntity.status(200).body(tack);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> registrarTrack(@RequestBody TrackRequestDto trackRequestDto){
        try {

            return ResponseEntity.ok().body(trackService.save(trackRequestDto).toDto());
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable("id") @Positive Long id){
        try {
            trackService.delete(id);
            return ResponseEntity.ok().body("Track deleted");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarTrack(@PathVariable("id")@Positive Long id,@RequestBody TrackRequestDto trackRequestDto){
        try {
            return ResponseEntity.ok().body(trackService.update(id,trackRequestDto).get().toDto());
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    /*
        Obtener todos los Tracks (Pistas o Canciones) dados un Artista y Un Id de género específicos (URL
    sugerida: GET:/api/tracks?artistid=<id de artista>&genreid=<id de género>). Para ello deberá
    buscar todos los tracks de todos los álbumes del artista indicado para componer una colección. El
    resultado debe informar: TrackId, tracks.Name, álbum.Title, artist.Name, miliseconds de cada
    uno de los tracks retornados (se sugiere crear un dto con esta estructura).
         */
    @GetMapping(params = {"artistid","genreid"})
    public ResponseEntity<?> getTracksByArtistAndGenre(@RequestParam("artistid") @Positive Long artistId,@RequestParam("genreid") @Positive Long genreId){
        try {
            List<TrackResponseByArtistDto> tracks = trackService.getTracksByArtistAndGenre(artistId,genreId)
                    .stream()
                    .map(TrackResponseByArtistDto::new)
                    .toList();
            if (tracks.isEmpty()){
                return ResponseEntity.status(204).body("No se encontraron tracks con los parametros ingresados");
            }
            return ResponseEntity.ok().body(tracks);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }



}
