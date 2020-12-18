package com.spartaglobal.jf.model;

import com.spartaglobal.jf.controller.ThreadPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

//Breaks array into 10 different ones
public class BreakArrays {


    public static void breakUp(HashMap<String, EmployeeDTO> arr, int dividedInto) {

        Logger logger = LogManager.getLogger(BreakArrays.class);
        //creates int that equally divides the array into 10 Lists
        //Math.ceil rounds values up to the nearest double
        //the (int) casts the Math.ceil value to an int to be used in the loop below
        int size = arr.size() / dividedInto;
        List<EmployeeDTO> hashToList = new ArrayList<>(arr.values());
        //A list placeholder to place all sublists
        List<List<EmployeeDTO>> brokenArr = new ArrayList<>();

        logger.debug("breaking up the employees into arrays");

        //loops to the size of the array in intervals of int size and sends them to the database
        for (int start = 0; start < arr.size(); start += size) {
            arr.values().stream().sorted();
            //Math min finds the smaller of two values, in this case we are adding the size to the start value
            //and comparing this to the arrays size, by adding the start size to the size divider
            //I can increment the size by the correct amount and find the end value for this divided array
            //unless its bigger than the total array length, otherwise its set to that value
            int end = Math.min(start + size, arr.size());

            //this breaks the array into a sublist starting from the incrementation and the Math.min outcome
                brokenArr.add(hashToList.subList((start), end));

            //This sends the value to a database in each increment
        }

        ThreadPool threadPool = new ThreadPool(brokenArr, brokenArr.size());
        logger.debug("Threads created with broken array and about to run.");
        threadPool.run();
    }

}
