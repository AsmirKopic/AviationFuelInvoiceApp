package com.tutorials.database;

import com.tutorials.model.Airline;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirlineDatabase implements AirlineDAO{

    public static final String INSERT_AIRLINE = "INSERT INTO airlines (airline_name, priceTerms, paymentTerms) " +
                                                "VALUES ( ?, ?, ?)";
    public static final String SELECT_ALL_AIRLINES = "SELECT * FROM airlines";
    public static final String FIND_AIRLINE_BY_NAME = "SELECT * FROM airlines WHERE airline_name = ?";
    public static final String UPDATE_AIRLINE = "UPDATE airlines SET priceTerms = ?, paymentTerms = ? WHERE airline_name = ?";
    public static final String DELETE_AIRLINE = "DELETE FROM airlines WHERE airline_name = ?";

    @Override
    public List<Airline> listAllAirlines() {

        List<Airline> airlines = new ArrayList<>();

        try(Connection conn = DBUtil.getConnection();
            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(SELECT_ALL_AIRLINES)){

                while (results.next()) {
                    Airline airline = new Airline();
                    airline.setName(results.getString(2));
                    airline.setPriceTerms(results.getDouble(3));
                    airline.setPaymentTerms(results.getInt(4));
                    airlines.add(airline);
                }

        } catch (SQLException e) {
            System.out.println("Cant execute query " + e.getMessage());
        }
        return  airlines;
    }

    @Override
    public Airline findAirlineByName(String name) {

        Airline airline = null;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement queryAirline = conn.prepareStatement(FIND_AIRLINE_BY_NAME)) {

                queryAirline.setString(1, name);
                ResultSet results = queryAirline.executeQuery();

                while (results.next()) {
                    airline = new Airline();
                    airline.setName(results.getString(2));
                    airline.setPriceTerms(results.getDouble(3));
                    airline.setPaymentTerms(results.getInt(4));
                }
                results.close();

        } catch (SQLException e) {
            System.out.println("Cant find airline" + e.getMessage());
        }

        return airline;
    }

    @Override
    public int insertAirline(Airline airline) {

        int status = 0;

        if (!isInDatabase(airline)){
            try (Connection conn = DBUtil.getConnection();
                 PreparedStatement newAirline = conn.prepareStatement(INSERT_AIRLINE)) {

                    newAirline.setString(1, airline.getName());
                    newAirline.setDouble(2, airline.getPriceTerms());
                    newAirline.setInt(3, airline.getPaymentTerms());

                    status = newAirline.executeUpdate();

            } catch (SQLException e) {
                System.out.println(" Cant execute query " + e.getMessage());
            }
        }
        return status;
    }

    @Override
    public int updateAirline(Airline airline) {

        int status = 0;

        if (isInDatabase(airline)) {
            try (Connection conn = DBUtil.getConnection();
                 PreparedStatement updateAirline = conn.prepareStatement(UPDATE_AIRLINE)) {

                    updateAirline.setString(1, airline.getName());
                    updateAirline.setDouble(2, airline.getPriceTerms());
                    updateAirline.setInt(3, airline.getPaymentTerms());

                    status = updateAirline.executeUpdate();

            } catch (SQLException e) {
                System.out.println(" Cant execute query - Update Airline " + e.getMessage());
            }
        }
        return status;
    }

    @Override
    public int deleteAirline(Airline airline) {

        int status = 0;

        if (isInDatabase(airline)) {
            try (Connection conn = DBUtil.getConnection();
                 PreparedStatement deleteAirline = conn.prepareStatement(DELETE_AIRLINE)) {

                    deleteAirline.setString(1, airline.getName());

                    status = deleteAirline.executeUpdate();

            } catch (Exception e) {
                System.out.println("Cant execute query - Delete Airline " + e.getMessage());
            }
        }
        return status;
    }

    @Override
    public boolean isInDatabase(Airline airline) {

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement queryAirline = conn.prepareStatement(FIND_AIRLINE_BY_NAME)) {

                queryAirline.setString(1, airline.getName());
                ResultSet results = queryAirline.executeQuery();

                if (results.next()){
                    return true;
                }
        } catch (SQLException e) {
            System.out.println("Cant execute query - is Airline in database " + e.getMessage());
        }
        return false;
    }

}
