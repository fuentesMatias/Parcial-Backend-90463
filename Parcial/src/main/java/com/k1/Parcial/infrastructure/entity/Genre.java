package com.k1.Parcial.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
CREATE TABLE "genres"
(
    [GenreId] INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    [Name] NVARCHAR(120)
);
 */
@Entity
@Table(name = "genres")
@Data
@NoArgsConstructor
public class Genre {

        @Id
        @GeneratedValue(generator = "genres")
        @TableGenerator(name = "genres", table = "sqlite_sequence",
                pkColumnName = "name", valueColumnName = "seq",
                pkColumnValue="genres",
                initialValue=1, allocationSize=1)
        @Column(name = "GenreId")
        private long id;

        @Column(name = "Name")
        private String name;
}
