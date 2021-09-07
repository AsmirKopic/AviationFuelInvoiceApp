package com.tutorials.database;

import com.tutorials.model.Airline;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirlineDatabase {

    public static final String DB_NAME = "aviationFuelService.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\HP\\Desktop\\Java Programms\\AviationFuel\\" + DB_NAME;

    public static final String INSERT_AIRLINE = "INSERT INTO airlines (name, priceTerms, paymentTerms) " +
            "VALUES ( ?, ?, ?)";
    public static final String SELECT_ALL_AIRLINES = "SELECT * FROM airlines";
    public static final String SELECT_AIRLINE = "SELECT * FROM airlines WHERE name = ?";
    public static final String DELETE_AIRLINE = "DELETE FROM airlines WHERE name=?";

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

    public void createAirline(Airline airline){
    }

    public List<Airline> listOfAirlines(){

        try(Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM airlines")){

            List<Airline> airlines = new ArrayList<>();
            while (results.next()){
                Airline airline = new Airline();
                airline.setName(results.getString(2));
                airline.setPriceTerms(results.getDouble(3));
                airline.setPaymentTerms(results.getInt(4));
                airlines.add(airline);
            }
            return airlines;
        } catch (SQLException e){
            System.out.println("Cant execute query " + e.getMessage());
            return null;
        }
    }



//         ** ListOfAirlines, ListAllInvoices, ListInvoicesByAirline, ListInvoicesByDate

//    public List<Artist> queryArtist(){
//
//        try(Statement statement = conn.createStatement();
//            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_ARTISTS)){
//
//            List<Artist> artists = new ArrayList<>();
//            while (results.next()){
//                Artist artist = new Artist();
//                artist.setId(results.getInt(COLUMN_ARTIST_ID));
//                artist.setName(results.getString(COLUMN_ARTIST_NAME));
//                artists.add(artist);
//            }
//            return artists;
//
//        } catch (SQLException e){
//            System.out.println("Query failed " + e.getMessage());
//            return null;
//        }
//    }
//              ** InsertInvoice // NewInvoice
//              ** InsertAirline
//



//    private int insertAlbum(String name,int artisId) throws SQLException {
//
//        // Check if artist is already in database
//        queryAlbum.setString(1, name);
//        ResultSet results = queryAlbum.executeQuery();
//        if (results.next()) {
//            return results.getInt(1);
//        } else {
//            // if album is not into database, insert album
//            insertIntoAlbums.setString(1, name);
//            insertIntoAlbums.setInt(2, artisId);
//            int affectedRows = insertIntoAlbums.executeUpdate();
//
//            if (affectedRows != 1) {
//                throw new SQLException("Couldn't insert album.");
//            }
//
//            ResultSet generatedKeys = insertIntoAlbums.getGeneratedKeys();
//            if(generatedKeys.next()){
//                return generatedKeys.getInt(1);
//            } else {
//                throw new SQLException("Couldn't get id from album");
//            }
//        }
//    }


}
