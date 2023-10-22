package com.k1.Parcial.infrastructure.entity;

/*
CREATE TABLE "albums"
(
    [AlbumId] INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    [Title] NVARCHAR(160)  NOT NULL,
    [ArtistId] INTEGER  NOT NULL,
    FOREIGN KEY ([ArtistId]) REFERENCES "artists" ([ArtistId])
		ON DELETE NO ACTION ON UPDATE NO ACTION
)
 */

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "artists")
@Data
@NoArgsConstructor
public class Album {

        @Id
        @GeneratedValue(generator = "albums")
        @TableGenerator(name = "albums", table = "sqlite_sequence",
                pkColumnName = "name", valueColumnName = "seq",
                pkColumnValue="albums",
                initialValue=1, allocationSize=1)
        @Column(name = "AlbumId")
        private long id;

        @Column(name = "Title")
        private String title;

        @ManyToOne
        @JoinColumn(name = "ArtistId")
        private Artist artist;
}
