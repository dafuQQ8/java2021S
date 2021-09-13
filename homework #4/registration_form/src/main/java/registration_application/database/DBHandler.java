/*
 *  Copyright (c) Monsters, Inc. All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by kagu-tsuchi <palerence@gmail.com>, September 2021
 */
package registration_application.database;

import registration_application.view.GlobalConstants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 * DBhandler i.e. Database handler is an abstract reference to a resource
 * that is used when application software references blocks of memory or objects
 * that are managed by MySQL database.
 *
 * @version 1.0 9 Sep 2021
 * @author kagu-tsuchi
 */
public class DBHandler extends Config {
    static Connection dbConnection;

    public static Connection getDBConnection () throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        return dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
    }

    public static void signUp (String variableColumn, String userInput) {
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        String toSQL = "INSERT INTO " + GlobalConstants.DATABASE + "(" + variableColumn + "," + GlobalConstants.CURRENT_DATE_DATABASE + ")" + "VALUES(?,?)";
        try {
            PreparedStatement prStatement = getDBConnection().prepareStatement(toSQL);
            prStatement.setString(1, userInput);
            prStatement.setTimestamp(2, date);
            prStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void addUpdate(String variableColumn, String userInput, String userName) {
        String toSQL = "UPDATE " + GlobalConstants.DATABASE + " SET " + variableColumn + " = ? WHERE Username = " + '"' + userName + '"';
        // UPDATE reg SET Firstname = 'smith' WHERE Username = "Smittie09"
        try {
            PreparedStatement prStatement = getDBConnection().prepareStatement(toSQL);
            prStatement.setString(1, userInput);
            prStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String executeQuery(String userName, String askedData) {
        String recievedData = "";
        String toSQL = "SELECT " + askedData + " FROM " + GlobalConstants.DATABASE + " WHERE Username = " + '"' + userName + '"';
        try {
            PreparedStatement prStatement = getDBConnection().prepareStatement(toSQL);
            ResultSet result = prStatement.executeQuery();
            if (result.next()) {
                recievedData = result.getString(askedData);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return recievedData;
    }

    public static boolean uniqueIndex(String nickName) {
        String toSQL = "SELECT * FROM "+ GlobalConstants.DATABASE + " WHERE " + GlobalConstants.USERNAME_DATABASE + "=?";

        try {
            PreparedStatement prStatement = getDBConnection().prepareStatement(toSQL);
            prStatement.setString(1, nickName);
            ResultSet result = prStatement.executeQuery();
            if (result.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void addSFP(String sfp, String userName) {
        addUpdate(GlobalConstants.SFP_DATABASE, sfp, userName);
    }
}
