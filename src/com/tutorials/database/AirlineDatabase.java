package com.tutorials.database;

import com.tutorials.model.Airline;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirlineDatabase implements AirlineDAO{

    public static final String DB_NAME = "aviationFuelService.db";
    //    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\HP\\Desktop\\Java Programms\\AviationFuel\\" + DB_NAME;
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\asmir\\Desktop\\AviationFuelTEST\\" + DB_NAME;


    public static final String INSERT_AIRLINE = "INSERT INTO airlines (airline_name, priceTerms, paymentTerms) " +
                                                "VALUES ( ?, ?, ?)";
    public static final String SELECT_ALL_AIRLINES = "SELECT * FROM airlines";
    public static final String FIND_AIRLINE_BY_NAME = "SELECT * FROM airlines WHERE airline_name = ?";
    public static final String DELETE_AIRLINE = "DELETE FROM airlines WHERE airline_name = ?";

    private Connection conn;
    private PreparedStatement newAirline;
    private PreparedStatement queryAirline;
    private PreparedStatement deleteAirline;
    private PreparedStatement updateAirline;    //needs to be implemented


    @Override
    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            newAirline = conn.prepareStatement(INSERT_AIRLINE);
            queryAirline = conn.prepareStatement(FIND_AIRLINE_BY_NAME);
            deleteAirline = conn.prepareStatement(DELETE_AIRLINE);
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't open connection." + e.getMessage());
            return false;
        }
    }

    @Override
    public void close() {
        try {
            if (newAirline != null) {
                newAirline.close();
            }
            if (queryAirline != null) {
                queryAirline.close();
            }
            if (deleteAirline != null) {
                deleteAirline.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection" + e.getMessage());
        }
    }

    @Override
    public List<Airline> findAllAirlines() {

        try(Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(SELECT_ALL_AIRLINES)){

            List<Airline> airlines = new ArrayList<>();
            while (results.next()) {
                Airline airline = new Airline();
                airline.setName(results.getString(2));
                airline.setPriceTerms(results.getDouble(3));
                airline.setPaymentTerms(results.getInt(4));
                airlines.add(airline);
            }
            return airlines;
        }catch (SQLException e) {
            System.out.println("Cant execute query " + e.getMessage());
            return null;
        }
    }

    @Override
    public Airline findAirlineByName(String name) {

        try {
            queryAirline.setString(1, name);
            ResultSet results = queryAirline.executeQuery();

            if (results.next()) {
                Airline airline = new Airline();
                airline.setName(results.getString(2));
                airline.setPriceTerms(results.getDouble(3));
                airline.setPaymentTerms(results.getInt(4));
                return airline;
            }
        } catch (SQLException e) {
            System.out.println("Cant find airline" + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean insertAirline(Airline airline) {

        if (!isInDatabase(airline)){
            try {
                newAirline.setString(1, airline.getName());
                newAirline.setDouble(2, airline.getPriceTerms());
                newAirline.setInt(3, airline.getPaymentTerms());
                newAirline.executeUpdate();
                return true;
            } catch (SQLException e) {
                System.out.println(" Cant execute query " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean updateAirline(Airline airline) {
        return false;
    }

    @Override
    public boolean deleteAirline(Airline airline) {
        return false;
    }

    @Override
    public boolean isInDatabase(Airline airline) {

        try {
            queryAirline.setString(1, airline.getName().toString());
            ResultSet results = queryAirline.executeQuery();

            if (results.next()){
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Cant execute query" + e.getMessage());
        }
        return false;
    }


}
