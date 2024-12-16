package org.gilsid.keynote.service;

import org.gilsid.keynote.service.dtos.KeynoteDTO;

import java.util.List;

public interface KeynoteService {
    List<KeynoteDTO> getAllKeynotes();
    KeynoteDTO getKeynoteById(Long id);
    KeynoteDTO createKeynote(KeynoteDTO keynoteDTO);
    KeynoteDTO updateKeynote(Long id, KeynoteDTO keynoteDTO);
    void deleteKeynote(Long id);
}