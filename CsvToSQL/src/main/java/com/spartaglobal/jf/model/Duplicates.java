package com.spartaglobal.jf.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

//finds a list of duplicates
public class Duplicates {

    WritingDupesToFile writing = new WritingDupesToFile();
    Logger logger = LogManager.getLogger(Duplicates.class);

    public HashMap<String, EmployeeDTO> hashDupeCheck(LinkedList<EmployeeDTO> employees)
    {
        Long start = System.nanoTime();
        logger.debug("Duplicate check started");
        HashMap<String, EmployeeDTO> hashEmployees = new HashMap<>();
        List<EmployeeDTO> removed = new ArrayList<>();

        for(EmployeeDTO e : employees)
        {
            if(hashEmployees.containsKey(e.getEmpID()))
            {
                removed.add(e);
                removed.add(hashEmployees.get(e.getEmpID()));
            }
            else
            {
                hashEmployees.put(e.getEmpID(), e);
            }
        }

        for(EmployeeDTO e : removed)
        {
            hashEmployees.remove(e.getEmpID());
        }

        System.out.println(removed.size());
        System.out.println(hashEmployees.size());

        Long end = System.nanoTime();
        System.out.println("Duplicate finding took: " + ((end - start)/1_000_000) + "ms");
        logger.debug("Finished checking for duplicates");
        writing.conversionToFile(removed);
        return hashEmployees;
    }

}
