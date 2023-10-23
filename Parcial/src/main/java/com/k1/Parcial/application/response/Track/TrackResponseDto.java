package com.k1.Parcial.application.response.Track;

import com.k1.Parcial.infrastructure.entity.Playlist;
import com.k1.Parcial.infrastructure.entity.Track;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TrackResponseDto {
    private long id;
    private String name;
    private long albumId;
    private long mediaTypeId;
    private long genreId;
    private String composer;
    private long milliseconds;
    private long bytes;
    private double unitPrice;
    private List<?> playlists;

    public TrackResponseDto(Track track) {
        this.id = track.getId();
        this.name = track.getName();
        this.albumId = track.getAlbum().getId();
        this.mediaTypeId = track.getMediaType().getId();
        this.genreId = track.getGenre().getId();
        this.composer = track.getComposer();
        this.milliseconds = track.getMilliseconds();
        this.bytes = track.getBytes();
        this.unitPrice = track.getUnitPrice();
        this.playlists = track.getPlaylists().stream()
                .map(Playlist::getName)
                .toList();
    }

}
