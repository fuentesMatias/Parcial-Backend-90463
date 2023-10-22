package com.k1.Parcial.infrastructure.entity;

/*
CREATE TABLE "artists"
(
    [ArtistId] INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    [Name] NVARCHAR(120)
);
 */

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "artists")
@Data
@NoArgsConstructor
public class Artist {

    @Id
    @GeneratedValue(generator = "artists")
    @TableGenerator(name = "artists", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="artists",
            initialValue=1, allocationSize=1)
    @Column(name = "ArtistId")
    private long id;

    @Column(name = "Name")
    private String name;
}
