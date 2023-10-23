package com.k1.Parcial.application.controller;


import com.k1.Parcial.application.request.Track.TrackRequestDto;
import com.k1.Parcial.application.response.Track.TrackResponseDto;
import com.k1.Parcial.domain.service.serviceInterfaces.TrackService;
import com.k1.Parcial.infrastructure.entity.Track;
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
    public ResponseEntity<?> getTrackById(@PathVariable("id") Long id){
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

            return ResponseEntity.ok().body(trackService.save(trackRequestDto));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable("id") Long id){
        try {
            trackService.delete(id);
            return ResponseEntity.ok().body("Track deleted");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarTrack(@PathVariable("id") Long id,@RequestBody TrackRequestDto trackRequestDto){
        try {
            return ResponseEntity.ok().body(trackService.update(id,trackRequestDto).get().toDto());
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
