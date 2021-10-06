package com.tutorials.database;

import com.tutorials.model.Airline;

import java.util.List;

public interface AirlineDAO {

    /**
     * <p>
     * This method by using database query is returning list of all Airlines in the database.
     * </p>
     * @return list of Airline objects from database
     */
    List<Airline> listAllAirlines();

    /**
     * <p>
     * This method returning Airline object (airline) based on provided airline name.
     * </p>
     * @param name
     *                  this parameter is used to create database query for selecting
     *                  airline in database.
     * @return new Airline object from database.
     */
    Airline findAirlineByName(String name);

    /**
     * <p>
     * This method is used for adding new Airline object to database.
     * </p>
     * @param airline
     *                  this parameter is used to create database query for Airline object
     *                  that should be inserted into database.
     * @return 1 if new Airline object is added or 0 if it is not added to database
     */
    int insertAirline(Airline airline);

    /**
     * <p>
     * This method is used to update Airline object in database.
     * </p>
     * @param airline
     *                  this parameter is used to create database query for selecting
     *                  Airline that should be updated.
     * @return 1 if Airline is updated or 0 if it is not updated in database
     */
    int updateAirline(Airline airline);

    /**
     * <p>
     * This method is used to delete Airline object from database.
     * </p>
     * @param airlineName
     *                  this parameter is used to create database query for selecting
     *                  Airline object that should be deleted.
     * @return
     */
    int deleteAirline(String airlineName);

    /**
     * <p>
     * This method checks is Airline already in database, based on provided Airline object.
     * </p>
     * @param airline
     *                  this parameter is used to create database query to check is provided
     *                  Airline object in database.
     * @return true if Airline object is already in database or false if it is not.
     */
    boolean isInDatabase(Airline airline);

    /**
     * This method checks is Airline already in database, based on provided Airline object.
     * </p>
     * @param airlineName
     *                  this parameter is used to create database query to check is provided
     *                  Airline name in database.
     * @return true if Airline name is already in database or false if it is not.
     */
    boolean isInDatabase(String airlineName);
}


