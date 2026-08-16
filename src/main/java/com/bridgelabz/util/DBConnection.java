package com.bridgelabz.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/studentdb";

    private static final String USER = "postgres";

    private static final String PASSWORD = "Yogi@180523";

    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(URL, USER, PASSWORD);

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        return con;

    }

}