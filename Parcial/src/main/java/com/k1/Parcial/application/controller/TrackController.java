package com.k1.Parcial.application.controller;


import com.k1.Parcial.domain.service.serviceInterfaces.TrackService;
import com.k1.Parcial.infrastructure.entity.Track;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
            return ResponseEntity.ok().body(trackService.getAll());
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable("id") Long id){
        try {
            return ResponseEntity.status(200).body(trackService.getById(id).get());
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

    @PostMapping
    public ResponseEntity<?> registrarTrack(@RequestBody Track track){
        try {
            return ResponseEntity.ok().body(trackService.save(track));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> actualizarTrack(@RequestBody Track track){
        try {
            return ResponseEntity.ok().body(trackService.update(track).get());
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
