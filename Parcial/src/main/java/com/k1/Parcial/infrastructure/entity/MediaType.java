package com.k1.Parcial.infrastructure.entity;
/*
    CREATE TABLE "media_types"
(
    [MediaTypeId] INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    [Name] NVARCHAR(120)
)
 */

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "media_types")
@Data
@NoArgsConstructor
public class MediaType {

        @Id
        @GeneratedValue(generator = "media_types")
        @TableGenerator(name = "media_types", table = "sqlite_sequence",
                pkColumnName = "name", valueColumnName = "seq",
                pkColumnValue="media_types",
                initialValue=1, allocationSize=1)
        @Column(name = "MediaTypeId")
        private long id;

        @Column(name = "Name")
        private String name;
}
