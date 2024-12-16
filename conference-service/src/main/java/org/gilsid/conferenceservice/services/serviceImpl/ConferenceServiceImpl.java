package org.gilsid.conferenceservice.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.gilsid.conferenceservice.proxies.KeynoteServiceProxy;
import org.gilsid.conferenceservice.services.dtos.ConferenceDTO;
import org.gilsid.conferenceservice.dao.entities.Conference;
import org.gilsid.conferenceservice.services.dtos.KeynoteDTO;
import org.gilsid.conferenceservice.services.mappers.ConferenceMapper;
import org.springframework.stereotype.Service;

import org.gilsid.conferenceservice.dao.repositories.ConferenceRepository;
import org.gilsid.conferenceservice.services.ConferenceService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConferenceServiceImpl implements ConferenceService {

    private final ConferenceRepository conferenceRepository;
    private final KeynoteServiceProxy keynoteServiceProxy;
    private final ConferenceMapper conferenceMapper;

    @Override
    public List<ConferenceDTO> getAllConferences() {
        return conferenceRepository.findAll().stream()
                .map(conferenceMapper::toDTO)
                .peek(conferenceDTO -> {
                    for (var keynoteId : conferenceDTO.getKeynoteIds()) {
                        keynoteIdToKeynoteEntity(conferenceDTO, keynoteId);
                    }
                })
                .collect(Collectors.toList());
    }

    @Override
    public ConferenceDTO getConferenceById(Long id) {
        Conference conference = conferenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conference not found"));
        ConferenceDTO conferenceDTO = conferenceMapper.toDTO(conference);
        for (var keynoteId : conferenceDTO.getKeynoteIds()) {
            keynoteIdToKeynoteEntity(conferenceDTO, keynoteId);
        }
        return conferenceDTO;
    }

    @Override
    public ConferenceDTO createConference(ConferenceDTO conferenceDTO) {
        Conference conference = conferenceMapper.toEntity(conferenceDTO);
        conference = conferenceRepository.save(conference);

        var newConferenceDTO = conferenceMapper.toDTO(conference);
        for (var keynoteId : conferenceDTO.getKeynoteIds()) {
            keynoteIdToKeynoteEntity(conferenceDTO, keynoteId);
        }

        return newConferenceDTO;
    }

    @Override
    public ConferenceDTO updateConference(Long id, ConferenceDTO conferenceDTO) {
        Conference conference = conferenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conference not found"));

        conference = conferenceRepository.save(conferenceMapper.toEntity(conferenceDTO));
        var newConferenceDTO = conferenceMapper.toDTO(conference);
        for (var keynoteId : conferenceDTO.getKeynoteIds()) {
            keynoteIdToKeynoteEntity(conferenceDTO, keynoteId);
        }

        return newConferenceDTO;
    }

    @Override
    public void deleteConference(Long id) {
        conferenceRepository.deleteById(id);
    }

    private void keynoteIdToKeynoteEntity(ConferenceDTO conferenceDTO, Long keynoteId) {
        KeynoteDTO keynoteDTO = keynoteServiceProxy.getKeynoteById(keynoteId);
        conferenceDTO.getKeynotes().add(keynoteDTO);
    }
}