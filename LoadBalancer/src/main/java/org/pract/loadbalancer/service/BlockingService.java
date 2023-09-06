package org.pract.loadbalancer.service;

import lombok.NoArgsConstructor;
import org.pract.loadbalancer.exception.DownStreamServiceNotAvailableException;
import org.pract.loadbalancer.model.Request;
import org.pract.loadbalancer.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.sleep;

@NoArgsConstructor
public class BlockingService implements ServiceIface {
    ResourceBundle rd
            = ResourceBundle.getBundle("application");
    Logger logger = LoggerFactory.getLogger(BlockingService.class);
    public static final int SLEEP_BLOCK_MILLIS = 2000;

    @Override
    public Response serveRequest(Request request) throws DownStreamServiceNotAvailableException {
        int sleepTime = Integer.parseInt(rd.getString("sleeptime_ms"));
        try {
            logger.info("blocking service will sleep for {}", sleepTime);
            sleep(sleepTime);
        } catch (InterruptedException e) {
            logger.error("thread got wake interrupted exception");
        }

        int randomNum = ThreadLocalRandom.current().nextInt(1, 10 + 1);
        if (randomNum == 7){
            logger.error("mimicking down service");
            throw new DownStreamServiceNotAvailableException("7 exception");
        }
        return new Response( "ok ");
    }
}
