package com.stackroute.jdbc;

import java.sql.*;

public class DatabaseMetadataDemo {

    public void getDetabaseMetaData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "Root@123");

            PreparedStatement statement = connection.prepareStatement("select * from employee");



            ResultSet resultSet = statement.executeQuery();

            DatabaseMetaData dbmd=connection.getMetaData();
            System.out.println("Driver Name: "+dbmd.getDriverName());
            System.out.println("Driver Version: "+dbmd.getDriverVersion());
            System.out.println("UserName: "+dbmd.getUserName());
            System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());
            System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());
        }




        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }


    }


}