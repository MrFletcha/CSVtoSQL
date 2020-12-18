package com.spartaglobal.jf;

import com.mysql.cj.jdbc.ha.MultiHostMySQLConnection;
import com.spartaglobal.jf.controller.CVSReader;
import com.spartaglobal.jf.model.EmployeeDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CorrectNumberOfLinesRead {

    @Test
    public void reading()
    {
        CVSReader reader = new CVSReader();
        HashMap<String, EmployeeDTO> arr = reader.readEmployees("src/main/resources/EmployeeRecords.csv");
        ArrayList<EmployeeDTO> arrToArray = new ArrayList<>(arr.values());
        Long lines = arrToArray.stream().count();
        Assertions.assertEquals(9886, lines);
    }

    @Test
    public void dataBase()
    {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/csvproject", "root", "root");
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("Select count(*) As totalRows from `csvproject`.`employees`");
            int totalRows = resultSet.getInt("totalRows");
            Assertions.assertEquals(9886, totalRows);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
