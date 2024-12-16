package org.gilsid.conferenceservice.controller;

import lombok.RequiredArgsConstructor;
import org.gilsid.conferenceservice.services.dtos.ConferenceDTO;
import org.gilsid.conferenceservice.services.ConferenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conferences")
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "*")
public class ConferenceController {

    private final ConferenceService conferenceService;

    @GetMapping
    public List<ConferenceDTO> getAllConferences() {
        return conferenceService.getAllConferences();
    }

    @GetMapping("/{id}")
    public ConferenceDTO getConferenceById(@PathVariable Long id) {
        return conferenceService.getConferenceById(id);
    }

    @PostMapping
    public ConferenceDTO createConference(@RequestBody ConferenceDTO conferenceDTO) {
        return conferenceService.createConference(conferenceDTO);
    }

    @PutMapping("/{id}")
    public ConferenceDTO updateConference(@PathVariable Long id, @RequestBody ConferenceDTO conferenceDTO) {
        return conferenceService.updateConference(id, conferenceDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteConference(@PathVariable Long id) {
        conferenceService.deleteConference(id);
    }
}