package com.k1.Parcial.application.response.Track;

import com.k1.Parcial.infrastructure.entity.Track;
import lombok.Data;

@Data
public class TrackResponseByArtistDto {
    Long TrackId;
    String Name;

    String AlbumTitle;

    String ArtistName;

    long milliseconds;


    public TrackResponseByArtistDto(Track track) {
        TrackId = track.getId();
        Name = track.getName();
        AlbumTitle = track.getAlbum().getTitle();
        ArtistName = track.getAlbum().getArtist().getName();
        milliseconds = track.getMilliseconds();

    }
}
