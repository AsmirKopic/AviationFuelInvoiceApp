package com.tutorials.database;

import com.tutorials.model.Airline;

import java.util.List;

public interface AirlineDAO {

    List<Airline> listAllAirlines();

    Airline findAirlineByName(String name);

    int insertAirline(Airline airline);

    int updateAirline(Airline airline);

    int deleteAirline(String airlineName);

    boolean isInDatabase(Airline airline);
    boolean isInDatabase(String airlineName);

}


