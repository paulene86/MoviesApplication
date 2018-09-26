package com.example.databaseengine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.h2.tools.DeleteDbFiles;


// H2 Database Example

public class H2DataBase {

	private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:~/test";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";

    public static void main(String[] args) throws Exception {
        try {
            // delete the H2 database named 'test' in the user home directory
            DeleteDbFiles.execute("~", "test", true);
            //insertWithStatement();
            DeleteDbFiles.execute("~", "test", true);
            insertWithPreparedStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // H2 SQL Prepared Statement Example
    private static void insertWithPreparedStatement() throws SQLException {
        Connection connection = getDBConnection();
        PreparedStatement createPreparedStatement = null;
//        PreparedStatement insertPreparedStatement = null;
//        PreparedStatement selectPreparedStatement = null;

        String CreateQuery =  "CREATE TABLE MOVIES(movie_name  varchar(255) primary key, year int)";
        String CreateQuery2 = "CREATE TABLE ACTORS(actor_name  varchar(255) primary key, year int, active varchar(1))";
        String CreateQuery3 = "CREATE TABLE MOVIE_ACTOR(movie_name  varchar(255) , actor_name  varchar(255),"
        		+ " primary key (moviename,actorname),"
        		+ " foreign key (moviename) references MOVIES(name),"
        		+ "	foreign key (actorname) references MOVIES(name))";
//        String InsertQuery = "INSERT INTO MOVIES" + "(name, year) values" + "(?,?)";
//        String SelectQuery = "select * from MOVIES";
        try {
            connection.setAutoCommit(false);
           
            createPreparedStatement = connection.prepareStatement(CreateQuery);
            createPreparedStatement = connection.prepareStatement(CreateQuery2);
            createPreparedStatement = connection.prepareStatement(CreateQuery3);


            createPreparedStatement.executeUpdate();
            createPreparedStatement.close();
           
//            insertPreparedStatement = connection.prepareStatement(InsertQuery);
//            insertPreparedStatement.setString(1, "Adan y Eva");
//            insertPreparedStatement.setString(2, "2000");
//            insertPreparedStatement.executeUpdate();
//            insertPreparedStatement.close();
//           
//            selectPreparedStatement = connection.prepareStatement(SelectQuery);
//            ResultSet rs = selectPreparedStatement.executeQuery();
//            System.out.println("H2 Database inserted through PreparedStatement");
//            while (rs.next()) {
//                System.out.println("Id "+rs.getString("name")+" Name "+rs.getInt("year"));
//            }
//            selectPreparedStatement.close();
           
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }



    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
                    DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}