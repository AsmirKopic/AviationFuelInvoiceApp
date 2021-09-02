package com.tutorials.db;

import java.sql.*;
import java.util.ArrayList;

public class Database {

    public static final String DB_NAME = "aviationFuelService.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\HP\\Desktop\\AviationFuel\\" + DB_NAME;

    public static final String INSERT_AIRLINE = "INSERT INTO airlines (name) VALUES (?)";
    public static final String NEW_INVOICE = "INSERT INTO invoices " +
                        "(airline, invoice_number, date, flight_number, registration, quantity_lit)" +
                        " VALUES(?, ?, ?, ?, ?, ?)";

//    public static final String QUERY_ARTIST = "SELECT " + COLUMN_ARTIST_ID + " FROM " +
//            TABLE_ARTISTS + " WHERE " + COLUMN_ARTIST_NAME + " = ?";
//    public static final String QUERY_ALBUM = "SELECT " + COLUMN_ALBUM_ID + " FROM " +
//            TABLE_ALBUMS + " WHERE " + COLUMN_ALBUM_NAME + " = ?";


    private Connection conn;
    private PreparedStatement newAirline;
    private PreparedStatement newInvoice;

    private PreparedStatement queryAirlines;
    private PreparedStatement queryInvoices;
    private PreparedStatement queryInvoicesByAirline;


    public boolean open(){
        try{
            conn = DriverManager.getConnection(CONNECTION_STRING);
//            insertIntoArtists = conn.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
//            insertIntoAlbums = conn.prepareStatement(INSERT_ALBUMS, Statement.RETURN_GENERATED_KEYS);
//            insertIntoSongs = conn.prepareStatement(INSERT_SONGS);
//            queryArtist = conn.prepareStatement(QUERY_ARTIST);
//            queryAlbum = conn.prepareStatement(QUERY_ALBUM);

            return true;
        } catch (SQLException e){
            System.out.println("Couldn't open connection." + e.getMessage());
            return false;
        }
    }

    public void close(){
        try{
//            if (insertIntoArtists != null) {
//                insertIntoArtists.close();
//            }
//            if (insertIntoAlbums != null){
//                insertIntoAlbums.close();
            }

            if (conn != null){
                conn.close();
            }
        } catch (SQLException e){
            System.out.println("Couldn't close connection" + e.getMessage());
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
