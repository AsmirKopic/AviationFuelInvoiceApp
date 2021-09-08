package com.tutorials.database;

import com.tutorials.model.Airline;

import java.util.List;

public interface AirlineDAO {

    public boolean open();
    public void close();

    List<Airline> findAllAirlines();
    Airline findAirlineByName(String name);

    boolean insertAirline(Airline airline);
    boolean updateAirline(Airline airline);
    boolean deleteAirline(Airline airline);

    boolean isInDatabase(Airline airline);

}


