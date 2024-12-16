package org.gilsid.conferenceservice.services.dtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ConferenceDTO {
    private Long id;
    private String title;
    private String type;
    private LocalDateTime date;
    private int duration;
    private int registeredParticipants;
    private double score;
    private List<Long> keynoteIds = new ArrayList<>();
    private List<ReviewDTO> reviews = new ArrayList<>();
    private List<KeynoteDTO> keynotes = new ArrayList<>();
}