package com.k1.Parcial.infrastructure.entity;

/*
CREATE TABLE "tracks"
(
    [TrackId] INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    [Name] NVARCHAR(200)  NOT NULL,
    [AlbumId] INTEGER,
    [MediaTypeId] INTEGER  NOT NULL,
    [GenreId] INTEGER,
    [Composer] NVARCHAR(220),
    [Milliseconds] INTEGER  NOT NULL,
    [Bytes] INTEGER,
    [UnitPrice] NUMERIC(10,2)  NOT NULL,
    FOREIGN KEY ([AlbumId]) REFERENCES "albums" ([AlbumId])
		ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY ([GenreId]) REFERENCES "genres" ([GenreId])
		ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY ([MediaTypeId]) REFERENCES "media_types" ([MediaTypeId])
		ON DELETE NO ACTION ON UPDATE NO ACTION
)
 */


import com.k1.Parcial.application.request.Track.TrackRequestDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Entity
@Table(name = "tracks")
@Data
@NoArgsConstructor
public class Track {

            @Id
            @GeneratedValue(generator = "tracks")
            @TableGenerator(name = "tracks", table = "sqlite_sequence",
                    pkColumnName = "name", valueColumnName = "seq",
                    pkColumnValue="tracks",
                    initialValue=1, allocationSize=1)
            @Column(name = "TrackId")
            private long id;

            @Column(name = "Name")
            private String name;

            @ManyToOne
            @JoinColumn(name = "AlbumId") // Define la columna de la clave foránea
            private Album album;

            @ManyToOne
            @JoinColumn(name = "MediaTypeId") // Define la columna de la clave foránea
            private MediaType mediaType;

            @ManyToOne
            @JoinColumn(name = "GenreId") // Define la columna de la clave foránea
            private Genre genre;

            @Column(name = "Composer")
            private String composer;

            @Column(name = "Milliseconds")
            private long milliseconds;

            @Column(name = "Bytes")
            private long bytes;

            @Column(name = "UnitPrice")
            private double unitPrice;

            @ManyToMany(mappedBy = "tracks")
            private List<Playlist> playlists;

    public Track(TrackRequestDto trackRequestDto, Album album, Genre genre, MediaType mediaType) {
        this.name = trackRequestDto.getName();
        this.album = album;
        this.genre = genre;
        this.mediaType = mediaType;
        this.composer = trackRequestDto.getComposer();
        this.milliseconds = trackRequestDto.getMilliseconds();
        this.bytes = trackRequestDto.getBytes();
        this.unitPrice = trackRequestDto.getUnitPrice();
    }
}
