package org.gilsid.keynote.controller;

import lombok.RequiredArgsConstructor;
import org.gilsid.keynote.service.KeynoteService;
import org.gilsid.keynote.service.dtos.KeynoteDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/keynotes")
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "*")
public class KeynoteController {

    private final KeynoteService keynoteService;

    @GetMapping
    public List<KeynoteDTO> getAllKeynotes() {
        return keynoteService.getAllKeynotes();
    }

    @GetMapping("/{id}")
    public KeynoteDTO getKeynoteById(@PathVariable Long id) {
        return keynoteService.getKeynoteById(id);
    }

    @PostMapping
    public KeynoteDTO createKeynote(@RequestBody KeynoteDTO keynoteDTO) {
        return keynoteService.createKeynote(keynoteDTO);
    }

    @PutMapping("/{id}")
    public KeynoteDTO updateKeynote(@PathVariable Long id, @RequestBody KeynoteDTO keynoteDTO) {
        return keynoteService.updateKeynote(id, keynoteDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteKeynote(@PathVariable Long id) {
        keynoteService.deleteKeynote(id);
    }
}