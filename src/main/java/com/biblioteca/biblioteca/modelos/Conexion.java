/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.biblioteca.modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection connection = null;
    private String url = "";
    private String server = "80.211.39.128:3310";
    private String user = "m2";
    private String pass = "metodologia2";
    private String dataBase = "biblioteca_db";

    public void connect() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            url = "jdbc:mysql://" + server + "/" + dataBase;
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Conected");

        } catch (SQLException | ClassNotFoundException e) {

            System.out.println("Error");
            System.out.println(e);

        }

    }

    public Connection getConnection() {
        return connection;
    }

    public Connection closeConnection() {
        try {
            connection.close();
            System.out.println("close connection....ok");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        connection = null;
        return connection;
    }

}
