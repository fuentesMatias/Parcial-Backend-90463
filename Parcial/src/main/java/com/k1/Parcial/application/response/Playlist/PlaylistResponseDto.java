package com.k1.Parcial.application.response.Playlist;


import com.k1.Parcial.infrastructure.entity.Playlist;
import com.k1.Parcial.infrastructure.entity.Track;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class PlaylistResponseDto {
    private long id;
    private String name;
    private List<?> tracks;

    public PlaylistResponseDto(Playlist playlist) {
        this.id = playlist.getId();
        this.name = playlist.getName();
        // Utiliza streams para extraer los IDs de los tracks y construir una lista de Long
        this.tracks = playlist.getTracks().stream()
                .map(com.k1.Parcial.infrastructure.entity.Track::getName)
                .toList();

    }
}
