package org.gilsid.conferenceservice.dao.repositories;

import org.gilsid.conferenceservice.dao.entities.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConferenceRepository extends JpaRepository<Conference, Long> {
}