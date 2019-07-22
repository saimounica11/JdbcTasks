package com.stackroute.jdbc;

import java.sql.*;

public class ResultSetMetadataDemo {
    public void getMetaData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "Root@123");

            PreparedStatement statement = connection.prepareStatement("select * from employee");



            ResultSet resultSet = statement.executeQuery();
            ResultSetMetaData rsmd=resultSet.getMetaData();
            int count=rsmd.getColumnCount();
            System.out.println("column number: " + rsmd.getColumnCount());
            for(int i=1;i<=count;i++) {

                System.out.println("Column Name : " + rsmd.getColumnName(i));
                System.out.println("Column Type : " + rsmd.getColumnTypeName(i));
                System.out.println("Table Name : " +rsmd.getTableName(i));
            }



        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }


    }

}
