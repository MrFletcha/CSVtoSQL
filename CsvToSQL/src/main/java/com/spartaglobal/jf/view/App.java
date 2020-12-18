package com.spartaglobal.jf.view;

import com.spartaglobal.jf.controller.CVSReader;
import com.spartaglobal.jf.model.BreakArrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class App
{
    public static void main( String[] args ) {
        Logger logger = LogManager.getLogger(App.class);

        Long start = System.nanoTime();
        BreakArrays breakArrays = new BreakArrays();
        breakArrays.breakUp(CVSReader.readEmployees("src/main/resources/EmployeeRecords.csv"), 1);

        Long finish = System.nanoTime();

        logger.debug("Time taken to complete whole process is: " + ((finish - start) / 1_000_000 + "ms"));

    }
}
