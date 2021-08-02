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
            if (listOfAirlines.containsValue(airline)){
                listOfAirlines.remove(airline);
            } else{
                System.out.println("No match airline.");
            }
        }
    }

    public void listOfAirlines(){
        listOfAirlines.forEach((s, airline) -> System.out.println(airline));
    }
}

