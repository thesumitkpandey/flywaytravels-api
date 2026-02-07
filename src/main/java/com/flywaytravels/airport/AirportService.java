package com.flywaytravels.airport;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AirportService {

    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<AirportResponseDTO> searchAirports(String keyword) {

        List<AirportEntity> airportResults = airportRepository.search(keyword);
        
        List<AirportResponseDTO> airports = new ArrayList<>();
        for (AirportEntity airport : airportResults) {
            AirportResponseDTO dto = new AirportResponseDTO();
            dto.setAirportName(airport.getAirportName());
            dto.setIataCode(airport.getIataCode());
            dto.setCityName(airport.getCityName());
            airports.add(dto);
        }
        return airports;
    }

}
