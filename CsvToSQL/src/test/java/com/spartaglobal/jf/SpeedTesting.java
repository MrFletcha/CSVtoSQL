package com.spartaglobal.jf;

import com.spartaglobal.jf.controller.CVSReader;
import com.spartaglobal.jf.model.EmployeeDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpeedTesting {

    @Test
    public static void main(String[] args)
    {
        Long hashSpeed = SpeedTesting.hashDupeCheck(CVSReader.readEmployees("src/main/resources/EmployeeRecords.csv"));
        Long arraySpeed = SpeedTesting.findDuplicates(CVSReader.readEmployees("src/main/resources/EmployeeRecords.csv"));
        Assertions.assertTrue(hashSpeed<arraySpeed);
    }

    private static Long hashDupeCheck(HashMap<String, EmployeeDTO> employees)
    {
        HashMap<String, EmployeeDTO> hashEmployees = new HashMap<>();
        LinkedList<EmployeeDTO> removed = new LinkedList<>();
        Long start = System.nanoTime();

        for(String e : employees.keySet())
        {
            if(hashEmployees.containsKey(e))
            {
                removed.add(employees.get(e));
                removed.add(hashEmployees.get(e));
            }
            else
            {
                hashEmployees.put(e, employees.get(e));
            }
        }

        for(EmployeeDTO e : hashEmployees.values())
        {
            if(employees.containsValue(e.geteMail()))
            {
                System.out.println(e.toString());
            }
        }
        System.out.println(removed.size() + " removed Array");
        System.out.println(hashEmployees.size()+ " hashed List");
        System.out.println(employees.size() + " original List");
        Long end = System.nanoTime();
        return ((end - start)/1_000_000);

    }

    public static Long findDuplicates(HashMap<String, EmployeeDTO> employeesArr) {
        ArrayList<EmployeeDTO> employees = new ArrayList<>(employeesArr.values());

        Long start = System.nanoTime();

        ArrayList<EmployeeDTO> removed = new ArrayList<>();
        int i = 0;

        while (i < employees.size()) {
            for (EmployeeDTO e : employees) {
                if (employees.get(i).getEmpID().equals(e.getEmpID()) && !employees.get(i).equals(e)) {
                    removed.add(e);
                }
                if(employees.get(i).geteMail().equals(e.getEmpID()) && !employees.get(i).equals(e))
                {
                    removed.add(e);
                }
            }
            i++;
        }

        Long end = System.nanoTime();
        return ((end - start)/1_000_000);
    }
}
