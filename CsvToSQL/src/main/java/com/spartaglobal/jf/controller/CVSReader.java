package com.spartaglobal.jf.controller;

import com.spartaglobal.jf.model.Duplicates;
import com.spartaglobal.jf.model.EmployeeDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


//Reads csv file into an arrayList
public class CVSReader {

    private static BufferedReader bufferedReader;
    private static LinkedList<EmployeeDTO> employees;

    public static HashMap<String, EmployeeDTO> readEmployees(String path) {

        Logger logger = LogManager.getLogger(CVSReader.class);
        Long start = System.nanoTime();
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            bufferedReader.readLine();
            employees = bufferedReader.lines()
                    .map(line -> line.split(","))
                    .map(temp -> new EmployeeDTO(
                    temp[0],
                    temp[1],
                    temp[2],
                    temp[3],
                    temp[4],
                    temp[5],
                    temp[6],
                    temp[7],
                    temp[8],
                    temp[9])).collect(Collectors.toCollection(LinkedList::new));
            bufferedReader.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        Long end = System.nanoTime();
        System.out.println("Reading took: " + ((end - start)/1_000_000) + "ms");
        Duplicates duplicates = new Duplicates();
        HashMap<String, EmployeeDTO> employeesH = duplicates.hashDupeCheck(employees);
        logger.debug("Read all lines into java from: " + path);
        return employeesH;
    }
}
