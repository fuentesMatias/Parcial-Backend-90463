package com.k1.Parcial.application.request.Track;

import lombok.Data;

@Data
public class TrackRequestDto {
    private String name;

    private long albumId;
    private long genreId;
    private long mediaTypeId;


    private String composer;
    private Long milliseconds;
    private Long bytes;
    private Double unitPrice;

}
