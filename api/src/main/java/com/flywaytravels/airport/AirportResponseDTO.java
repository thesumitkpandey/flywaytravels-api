package com.flywaytravels.airport;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AirportResponseDTO {
    private String cityName;
    private String airportName;
    private String iataCode;
}