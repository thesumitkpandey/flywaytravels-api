package com.flywaytravels.airport;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "airports")
@Getter
@Setter
public class Airport {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "iata_code", nullable = false, length = 20)
    private String iataCode;

    @Column(name = "city_code", length = 20)
    private String cityCode;

    @Column(name = "country_code", length = 20)
    private String countryCode;

    @Column(name = "state_code", length = 20)
    private String stateCode;

    @Column(name = "region_code", length = 20)
    private String regionCode;

    @Column(name = "airport_name", nullable = false, length = 400)
    private String airportName;

    @Column(name = "city_name", nullable = false, length = 400)
    private String cityName;

    @Column(name = "country_name", nullable = false, length = 400)
    private String countryName;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "timezone_offset", length = 10)
    private String timezoneOffset;

}
