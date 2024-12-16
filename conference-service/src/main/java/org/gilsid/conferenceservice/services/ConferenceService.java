package org.gilsid.conferenceservice.services;

import org.gilsid.conferenceservice.services.dtos.ConferenceDTO;

import java.util.List;

public interface ConferenceService {
    List<ConferenceDTO> getAllConferences();
    ConferenceDTO getConferenceById(Long id);
    ConferenceDTO createConference(ConferenceDTO conferenceDTO);
    ConferenceDTO updateConference(Long id, ConferenceDTO conferenceDTO);
    void deleteConference(Long id);
}