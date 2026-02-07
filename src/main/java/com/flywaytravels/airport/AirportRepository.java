package com.flywaytravels.airport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<AirportEntity, Long> {

@Query("""
   SELECT a FROM AirportEntity a
   WHERE LOWER(a.iataCode) LIKE LOWER(CONCAT('%', :q, '%'))
      OR LOWER(a.cityName) LIKE LOWER(CONCAT('%', :q, '%'))
      OR LOWER(a.airportName) LIKE LOWER(CONCAT('%', :q, '%'))
""")
List<AirportEntity> search(@Param("q") String q);

}
