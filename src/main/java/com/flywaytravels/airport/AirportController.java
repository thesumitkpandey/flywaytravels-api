package com.flywaytravels.airport;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/api/airports/search")
    public List<AirportResponseDTO> searchAirports(
            @RequestParam String keyword
    ) {
        log.info("Searching airports for keyword: {}", keyword);
        return airportService.searchAirports(keyword);
    }
}
