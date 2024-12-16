package org.gilsid.conferenceservice.services.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewDTO {
    private Long id;
    private LocalDateTime date;
    private String text;
    private int stars;
    private Long conferenceId;
}