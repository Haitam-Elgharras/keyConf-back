package org.gilsid.conferenceservice.services.mappers;


import org.gilsid.conferenceservice.dao.entities.Conference;
import org.gilsid.conferenceservice.services.dtos.ConferenceDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConferenceMapper {

        ConferenceDTO toDTO(Conference conference);

        Conference toEntity(ConferenceDTO conferenceDTO);

        List<ConferenceDTO> toDTOs(List<Conference> conferences);

        List<Conference> toEntities(List<ConferenceDTO> conferenceDTOs);
}
