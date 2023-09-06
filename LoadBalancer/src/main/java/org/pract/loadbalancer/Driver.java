package org.pract.loadbalancer;

import org.pract.loadbalancer.exception.DownStreamServiceNotAvailableException;
import org.pract.loadbalancer.model.Request;
import org.pract.loadbalancer.model.ServiceRegistrationRequest;
import org.pract.loadbalancer.repository.LoadBalancerRepository;
import org.pract.loadbalancer.repository.ServiceRepository;
import org.pract.loadbalancer.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;


import static org.slf4j.LoggerFactory.getLogger;

public class Driver {
    private static Logger logger = getLogger(Driver.class);
    ResourceBundle rd
            = ResourceBundle.getBundle("application");

    public static void main(String[] args) {
        logger.debug("Starting Load balancer service");
        Map<String, LoadBalancerIface> loadBalancerIfaceMap = new ConcurrentHashMap<>();
        Map<String, ServiceIface> serviceMap = new ConcurrentHashMap<>();

        LoadBalancerRepository loadBalancerRepository = new LoadBalancerRepository( loadBalancerIfaceMap );
        ServiceRepository serviceRepository = new ServiceRepository( serviceMap);
        AbstractLoadBalancer loadBalancer = new RoundRobinLoadBalancer( loadBalancerRepository, serviceRepository );

        loadBalancer.registerLoadBalancer( "/n", loadBalancer );
        loadBalancer.registerLoadBalancer( "/b", loadBalancer );

        ServiceIface blockingService = new BlockingService();
        ServiceRegistrationRequest serviceRegistrationRequest = new ServiceRegistrationRequest("/b", blockingService);
        loadBalancer.registerService( serviceRegistrationRequest );

        ServiceIface nonBlockingService = new NonBlockingService();
        ServiceRegistrationRequest nonBlockingserviceRegistrationRequest = new ServiceRegistrationRequest("/n", nonBlockingService);
        loadBalancer.registerService( nonBlockingserviceRegistrationRequest );

        try {
            loadBalancer.processRequest( new Request("/b") );
            loadBalancer.processRequest( new Request("/n") );
        } catch (DownStreamServiceNotAvailableException e) {
            logger.error("downstream service not available");
            throw new RuntimeException(e);
        }

    }

}
