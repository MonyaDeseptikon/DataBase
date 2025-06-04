package org.example;

import java.sql.*;
import java.util.ArrayList;

public class JDBC {
    private static final String url = "jdbc:mysql://localhost:3306";
    private static final String user = "user";
    private static final String password = "root";

    public static void main(String[] args) throws SQLException {
        Connection con = getConnections(url, user, password);
        Statement statement = con.createStatement();
//        statement.execute("DROP SCHEMA test");
        statement.execute("CREATE SCHEMA IF NOT EXISTS test");

        statement.execute("CREATE TABLE IF NOT EXISTS test.table " +
                "(id INT AUTO_INCREMENT PRIMARY KEY," +
                "firstname VARCHAR(45) NULL," +
                "lastname VARCHAR(45) NULL)");
        statement.execute("INSERT INTO test.table (id, firstname, lastname) "
                + "VALUES(1, 'Иван', 'Иванов');");
        statement.execute("INSERT INTO test.table"+
        "(id,lastname)" +
        "VALUES(2,'Петров');");

        ResultSet set = statement.executeQuery("SELECT * FROM test.table;");
        System.out.println(getDataFromSchema(set));
        System.out.println(set.getMetaData());

con.close();
    }

    public static Connection getConnections(String url, String user, String password) throws SQLException {
        Connection con = null;
                   con =DriverManager.getConnection(url, user, password);
               return con;
    }

    public static ArrayList<String> getDataFromSchema (ResultSet set) throws SQLException {
        ArrayList<String> list = new ArrayList<>();

        while (set.next()) {
            list.add(set.getInt(1) + " " + set.getString(2) + " " + set.getString(3));
        }
        return list;
    }
}