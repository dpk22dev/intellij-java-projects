package org.pract;

import org.slf4j.Logger;

import java.util.ResourceBundle;

import static org.slf4j.LoggerFactory.getLogger;

public class Main {
    private static Logger logger = getLogger(Main.class);
    static ResourceBundle rd
            = ResourceBundle.getBundle("application");
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String ms = rd.getString( "sleeptime_ms");

        logger.info("testing logging functionality {}", ms);
    }

}