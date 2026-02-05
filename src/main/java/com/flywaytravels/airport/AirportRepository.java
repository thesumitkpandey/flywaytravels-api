package com.flywaytravels.airport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<AirportEntity, Integer> {
    java.util.Optional<AirportEntity> findByIataCode(String iataCode);
}
