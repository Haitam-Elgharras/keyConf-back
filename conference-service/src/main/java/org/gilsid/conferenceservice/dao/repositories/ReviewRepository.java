package org.gilsid.conferenceservice.dao.repositories;

import org.gilsid.conferenceservice.dao.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
