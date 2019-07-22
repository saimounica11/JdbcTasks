package com.stackroute.jdbc;
import  com.sun.rowset.JdbcRowSetImpl;
import javax.sql.rowset.JdbcRowSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class RowSetDemo {
    private JdbcRowSet rowSet=null;
    public void getRowSet() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            rowSet = new JdbcRowSetImpl();
            rowSet.setUrl("jdbc:mysql://localhost:3306/demo");
            rowSet.setUsername("root");
            rowSet.setPassword("Root@123");
            rowSet.setCommand("SELECT * FROM emp");
            rowSet.execute();
            ResultSetMetaData metaData = rowSet.getMetaData();
            int noOfCols = metaData.getColumnCount();
            System.out.println("Employees");
            for (int i = 1; i <= noOfCols; i++) {
                System.out.printf("%-20s\t", metaData.getColumnName(i));
            }
            System.out.println();
            while (rowSet.next()) {
                for (int i = 1; i <= noOfCols; i++) {
                    System.out.printf("%-20s\t", rowSet.getObject(i));
                }
                System.out.println();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }
}