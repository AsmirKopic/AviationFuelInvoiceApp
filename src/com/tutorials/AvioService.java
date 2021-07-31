package com.tutorials;

import java.util.HashMap;
import java.util.Map;

public class AvioService {
    private Map<String, Airline> listOfAirlines;

    public AvioService() {
        listOfAirlines = new HashMap<>();
    }

    public boolean addAirline(Airline airline){
        if (airline != null){
            Airline inList = listOfAirlines.getOrDefault(airline, null);
            if (airline != inList){
                listOfAirlines.put(airline.getName(), airline);
                return true;
            }
        }
        return false;
    }

    public void removeAirline(Airline airline){
        if (airline != null){
            Airline inList = listOfAirlines.getOrDefault(airline.getName(), airline);
            if (inList != airline){
                System.out.println("No Airline to remove.");
            } else {
                listOfAirlines.remove(airline);
                System.out.println(airline + " removed from list.");
            }
        }
    }

    public void listOfAirlines(){
        for (Airline airline : listOfAirlines.values()){
            System.out.println(airline.getName());
        }
    }
}

