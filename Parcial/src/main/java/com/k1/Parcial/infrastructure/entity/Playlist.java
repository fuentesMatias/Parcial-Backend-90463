package com.k1.Parcial.infrastructure.entity;
/*
CREATE TABLE "playlists"
(
    [PlaylistId] INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    [Name] NVARCHAR(120)
)
 */
import com.k1.Parcial.application.request.Playlist.PlaylistRequestDto;
import com.k1.Parcial.application.response.Playlist.PlaylistResponseDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "playlists")
@Data
@NoArgsConstructor
public class Playlist {

            @Id
            @GeneratedValue(generator = "playlists")
            @TableGenerator(name = "playlists", table = "sqlite_sequence",
                    pkColumnName = "name", valueColumnName = "seq",
                    pkColumnValue="playlists",
                    initialValue=1, allocationSize=1)
            @Column(name = "PlaylistId")
            private long id;

            @Column(name = "Name")
            private String name;

            @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
            @JoinTable(
                    name = "playlist_track",
                    joinColumns = @JoinColumn(name = "PlaylistId"),
                    inverseJoinColumns = @JoinColumn(name = "TrackId")
            )
            private List<Track> tracks;

            public Playlist(PlaylistRequestDto playlistRequestDto) {
                this.name = playlistRequestDto.getName();
            }

            public PlaylistResponseDto toDto(){
                return new PlaylistResponseDto(this);
            }

            public Playlist addTrack(Track track) {
                this.tracks.add(track);
                return this;
            }
}
