package com.stackroute.jdbc;

import java.sql.*;

public class JdbcBatchDemo {
    public void getJdbcBatch() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "Root@123");

            connection.setAutoCommit(false);

            Statement statement=connection.createStatement();

            statement.addBatch("insert into employee values(4,'abhi',28,'m')");
            statement.addBatch("insert into employee values(5,'gautham',31,'m')");

            statement.executeBatch();
            connection.commit();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
