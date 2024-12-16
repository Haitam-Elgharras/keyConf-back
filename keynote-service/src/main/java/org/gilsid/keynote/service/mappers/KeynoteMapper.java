package org.gilsid.keynote.service.mappers;

import org.gilsid.keynote.dao.entities.Keynote;
import org.gilsid.keynote.service.dtos.KeynoteDTO;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KeynoteMapper {

    KeynoteDTO toDTO(Keynote keynote);

    Keynote toEntity(KeynoteDTO keynoteDTO);

    void updateEntityFromDTO(KeynoteDTO keynoteDTO, @MappingTarget Keynote keynote);
}