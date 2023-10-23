package com.k1.Parcial.application.request.Track;

import lombok.Data;

@Data
public class TrackRequestDto {
    private String name;
    private Long albumId;
    private Long genreId;
    private Long mediaTypeId;
    private String composer;
    private Long milliseconds;
    private Long bytes;
    private Double unitPrice;
}
