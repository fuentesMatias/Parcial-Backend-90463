package com.k1.Parcial.application.response.Playlist;


import com.k1.Parcial.infrastructure.entity.Playlist;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlaylistResponseDto {
    private long id;
    private String name;

    public PlaylistResponseDto(Playlist playlist) {
        this.id = playlist.getId();
        this.name = playlist.getName();
    }
}
