package org.gilsid.conferenceservice.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data @Builder
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Enumerated(EnumType.STRING)
    private ConferenceType type;
    private LocalDateTime date;
    private int duration;
    private int registeredParticipants;
    private double score;

    @ElementCollection
    private List<Long> keynoteIds = new ArrayList<>();

    @OneToMany(mappedBy = "conference", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();
}
