package com.example.ibatis;

import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Running");
        try {
            System.out.println(SimpleExample.selectEmployeeById(499999));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
