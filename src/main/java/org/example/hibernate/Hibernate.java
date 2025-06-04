package org.example.hibernate;

import java.sql.*;
import java.util.ArrayList;

public class Hibernate {
    private static final String url = "jdbc:mysql://localhost:3306";
    private static final String user = "user";
    private static final String password = "root";

    public static void main(String[] args) throws SQLException {
        Connection con = getConnections(url, user, password);
        Statement statement = con.createStatement();
//            statement.execute("DROP SCHEMA test");
            statement.execute("CREATE SCHEMA IF NOT EXISTS test");

        statement.execute("CREATE TABLE IF NOT EXISTS test.magic" +
                "(id INT NOT NULL AUTO_INCREMENT," +
                "название VARCHAR(45) NULL," +
                "повреждение INT NULL," +
                "атака INT NULL," +
                "броня INT NULL," +
                "PRIMARY KEY(id))");
        ResultSet set = statement.executeQuery("SELECT * FROM test.magic;");
        getDataFromSchema(set).forEach(s-> System.out.println(s));
        System.out.println(set.getMetaData());
        System.out.println(con.getMetaData());
    }

    public static Connection getConnections(String url, String user, String password) throws SQLException {
        Connection con = null;
        con = DriverManager.getConnection(url, user, password);
        return con;
    }

    public static ArrayList<String> getDataFromSchema(ResultSet set) throws SQLException {
        ArrayList<String> list = new ArrayList<>();

        while (set.next()) {
            list.add(set.getInt(1) + " " + set.getString(2) + " " + set.getInt(3)+
                    " " + set.getInt(4)+
                    " " + set.getInt(5)+'\n');
        }
        return list;
    }


}
