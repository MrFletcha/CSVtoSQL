package com.spartaglobal.jf.model;

import com.spartaglobal.jf.controller.CVSReader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.*;
import java.util.List;

//Connects to Database and inserts data
public class DBConnection implements Runnable {

    private static Connection connection;
    private static List<EmployeeDTO> employees;

    public DBConnection(List<EmployeeDTO> employees, Connection connection)
    {
        this.connection = connection;
        this.employees = employees;
    }
    @Override
    public void run()
    {
        Long start = System.currentTimeMillis();
        entryIntoDB(employees);
        Long finish = System.currentTimeMillis();
        System.out.println("This thread took: " + (finish - start));
    }

    public static void entryIntoDB(List<EmployeeDTO> arr) {
        try {
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/csvproject", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into `csvproject`.`employees`(`idEmployees`, `name_prefix`, `first_name`, `middle_initial`, `last_name`, `gender`, `email`, `date_of_birth`, `date_of_joining`, `salary`) values (?,?,?,?,?,?,?,?,?, ?)");
            for (EmployeeDTO e : arr) {
                preparedStatement.setInt(1, Integer.parseInt(e.getEmpID()));
                preparedStatement.setString(2, e.getNamePrefix());
                preparedStatement.setString(3, e.getFirstName());
                preparedStatement.setString(4, e.getMiddleInitial());
                preparedStatement.setString(5, e.getLastName());
                preparedStatement.setString(6, e.getGender());
                preparedStatement.setString(7, e.geteMail());
                preparedStatement.setDate(8, Date.valueOf(e.getDob()));
                preparedStatement.setDate(9, Date.valueOf(e.getDateJoining()));
                preparedStatement.setInt(10, e.getSalary());
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
