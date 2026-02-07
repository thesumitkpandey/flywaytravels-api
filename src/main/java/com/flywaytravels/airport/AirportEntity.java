package com.flywaytravels.airport;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "airports")
@Getter
@Setter
public class AirportEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "iata_code", nullable = false, length = 20)
    private String iataCode;

    @Column(name = "airport_name", nullable = false, length = 400)
    private String airportName;

    @Column(name = "city_name", nullable = false, length = 400)
    private String cityName;

    @Column(name = "country_name", nullable = false, length = 400)
    private String countryName;

}
