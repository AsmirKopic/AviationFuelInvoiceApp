package com.tutorials.database;

import com.tutorials.model.Airline;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirlineDatabase {

    public static final String DB_NAME = "aviationFuelService.db";
    //    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\HP\\Desktop\\Java Programms\\AviationFuel\\" + DB_NAME;
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\asmir\\Desktop\\AviationFuelTEST\\" + DB_NAME;


    public static final String INSERT_AIRLINE = "INSERT INTO airlines (name, priceTerms, paymentTerms) " +
            "VALUES ( ?, ?, ?)";
    public static final String SELECT_ALL_AIRLINES = "SELECT * FROM airlines";
    public static final String SELECT_AIRLINE = "SELECT * FROM airlines WHERE name = ?";
    public static final String DELETE_AIRLINE = "DELETE FROM airlines WHERE name = ?";

    private Connection conn;
    private PreparedStatement newAirline;
    private PreparedStatement queryAirline;
    private PreparedStatement deleteAirline;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            newAirline = conn.prepareStatement(INSERT_AIRLINE);
            queryAirline = conn.prepareStatement(SELECT_AIRLINE);
            deleteAirline = conn.prepareStatement(DELETE_AIRLINE);
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't open connection." + e.getMessage());
            return false;
        }
    }

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

    public boolean insertAirline(String name, double priceTerms, int paymentTerms) throws SQLException {

        // Check is airline already in database
        queryAirline.setString(1, name);
        ResultSet results = queryAirline.executeQuery();
        if (results.next()) {
            return false;
        } else {
            // if airline is not in database, insert airline
            newAirline.setString(1, name);
            newAirline.setDouble(2, priceTerms);
            newAirline.setInt(3, paymentTerms);

            int update = newAirline.executeUpdate();

            if (update != 1) {
                throw new SQLException("Couldn't add airline.");
            } else {
                return true;
            }
        }
    }

    public List<Airline> listOfAirlines() {

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(SELECT_ALL_AIRLINES)) {

            List<Airline> airlines = new ArrayList<>();
            while (results.next()) {
                Airline airline = new Airline();
                airline.setName(results.getString(2));
                airline.setPriceTerms(results.getDouble(3));
                airline.setPaymentTerms(results.getInt(4));
                airlines.add(airline);
            }
            return airlines;
        } catch (SQLException e) {
            System.out.println("Cant execute query " + e.getMessage());
            return null;
        }
    }

    public Airline selectAirline(String name) {

        try {
            queryAirline.setString(1, name);
            ResultSet results = queryAirline.executeQuery();

            if (results.next()) {
                Airline airline = new Airline();
                airline.setName(results.getString(2));
                airline.setPriceTerms(results.getDouble(3));
                airline.setPaymentTerms(results.getInt(4));
                return airline;
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Cant select airline" + e.getMessage());
            return null;
        }
    }

    public void editAirline(Airline airline) {
    }

    // need to fix this method
    public boolean deleteAirline(String name) throws SQLException {

        queryAirline.setString(1, name);
        ResultSet results = queryAirline.executeQuery();
        if (results.next()) {
            deleteAirline.setString(1, name);
            return true;
        } else {
            throw new SQLException("Delete failed. ");
        }
    }


}
