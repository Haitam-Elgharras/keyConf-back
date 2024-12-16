package org.gilsid.keynote.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.gilsid.keynote.dao.entities.Keynote;
import org.gilsid.keynote.dao.repositories.KeynoteRepository;
import org.gilsid.keynote.service.KeynoteService;
import org.gilsid.keynote.service.dtos.KeynoteDTO;
import org.gilsid.keynote.service.mappers.KeynoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KeynoteServiceImpl implements KeynoteService {

    private final KeynoteRepository keynoteRepository;
    private final KeynoteMapper keynoteMapper;

    @Override
    public List<KeynoteDTO> getAllKeynotes() {
        return keynoteRepository.findAll().stream()
                .map(keynoteMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public KeynoteDTO getKeynoteById(Long id) {
        Keynote keynote = keynoteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Keynote not found"));
        return keynoteMapper.toDTO(keynote);
    }

    @Override
    public KeynoteDTO createKeynote(KeynoteDTO keynoteDTO) {
        Keynote keynote = keynoteMapper.toEntity(keynoteDTO);
        keynote = keynoteRepository.save(keynote);
        return keynoteMapper.toDTO(keynote);
    }

    @Override
    public KeynoteDTO updateKeynote(Long id, KeynoteDTO keynoteDTO) {
        Keynote existingKeynote = keynoteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Keynote not found"));
        keynoteMapper.updateEntityFromDTO(keynoteDTO, existingKeynote);
        existingKeynote = keynoteRepository.save(existingKeynote);
        return keynoteMapper.toDTO(existingKeynote);
    }

    @Override
    public void deleteKeynote(Long id) {
        keynoteRepository.deleteById(id);
    }
}