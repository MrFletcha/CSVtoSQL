package com.spartaglobal.jf.controller;

import com.mysql.cj.x.protobuf.MysqlxNotice;
import com.spartaglobal.jf.model.DBConnection;
import com.spartaglobal.jf.model.EmployeeDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool implements Runnable {

    private static Connection connection;
    private static List<List<EmployeeDTO>> employees;
    private static Thread[] executor;
    Logger logger = LogManager.getLogger(ThreadPool.class);

    public ThreadPool(List<List<EmployeeDTO>> employees, int threadCount) {
        logger.debug("Constructor overrriden to hold list and number of arrays original list has been broken into");
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/csvproject", "root", "root");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        this.employees = employees;
        this.executor = new Thread[threadCount];
    }


    @Override
    public void run() {

        logger.debug("threads starting");
        for (int i = 0; i < executor.length; i++) {
            executor[i] = new Thread(new DBConnection(employees.get(i), connection));
            executor[i].start();
            System.out.println("Worker "+ i +" is doing: " + employees.get(i).stream().count());
        }
    }
}
