package com.spartaglobal.jf.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WritingDupesToFile {

    Logger logger = LogManager.getLogger(WritingDupesToFile.class);

    public void conversionToFile(List<EmployeeDTO> removed) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/Duplicates.csv"));
            writer.write(removed.toString());
            logger.debug("Writing duplicates to file");
            writer.close();
            logger.debug("Written to file, hopefully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
