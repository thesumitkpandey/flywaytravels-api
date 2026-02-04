package com.flywaytravels.airport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.flywaytravels.service.AmadeusAuthService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AirportService {

    private final AmadeusAuthService authService;

    private final WebClient webClient =
            WebClient.create("https://test.api.amadeus.com");

    public AirportService(AmadeusAuthService authService) {
        this.authService = authService;
    }

    public List<AirportResponseDTO> searchAirports(String keyword) {
        String token = authService.getAmadeusToken();

        Map<String, Object> response = webClient.get()
            .uri(uriBuilder -> uriBuilder
                .path("/v1/reference-data/locations")
                .queryParam("subType", "AIRPORT")
                .queryParam("keyword", keyword)
                .build())
            .header("Authorization", "Bearer " + token)
            .retrieve()
            .bodyToMono(Map.class)
            .block();

        log.info("Amadeus Airport Raw Response: {}", response);

        List<Map<String, Object>> data =
                (List<Map<String, Object>>) response.get("data");

        if (data == null || data.isEmpty()) {
            return Collections.emptyList();
        }

        List<AirportResponseDTO> result = new ArrayList<>();

        for (Map<String, Object> airport : data) {

            AirportResponseDTO dto = new AirportResponseDTO();

            dto.setAirportName((String) airport.get("name"));
            dto.setIataCode((String) airport.get("iataCode"));

            Map<String, Object> address =
                    (Map<String, Object>) airport.get("address");

            if (address != null) {
                dto.setCityName((String) address.get("cityName"));
            }

            result.add(dto);
        }

        return result;
    }

    
}
