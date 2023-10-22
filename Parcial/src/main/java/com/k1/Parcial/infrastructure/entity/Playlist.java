package com.k1.Parcial.infrastructure.entity;
/*
CREATE TABLE "playlists"
(
    [PlaylistId] INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    [Name] NVARCHAR(120)
)
 */
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

            @ManyToMany
            @JoinTable(
                    name = "playlist_track",
                    joinColumns = @JoinColumn(name = "PlaylistId"),
                    inverseJoinColumns = @JoinColumn(name = "TrackId")
            )
            private List<Track> tracks;

}
