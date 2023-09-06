package org.pract.loadbalancer.repository;

import org.pract.loadbalancer.exception.LoadBalancerAlreadyAssignedException;
import org.pract.loadbalancer.exception.PathNotFoundException;
import org.pract.loadbalancer.model.ServiceRegistrationResponse;
import org.pract.loadbalancer.service.LoadBalancerIface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoadBalancerRepository {

    private static Logger logger = LoggerFactory.getLogger(LoadBalancerRepository.class);
    private Map<String, LoadBalancerIface> loadBalancerIfaceMap;

    public LoadBalancerRepository(Map<String, LoadBalancerIface> loadBalancerIfaceMap) {
        this.loadBalancerIfaceMap = loadBalancerIfaceMap;
    }

    public boolean addLoadBalancer(String path, LoadBalancerIface loadBalancer){
        if(loadBalancerIfaceMap.get( path ) != null) {
            logger.error("load balancer already assigned to this path");
            throw new LoadBalancerAlreadyAssignedException(path);
        }
        loadBalancerIfaceMap.computeIfAbsent( path, k -> loadBalancer );
        return true;
    }


    public boolean removeLoadBalancer(String path, LoadBalancerIface loadBalancer) {
        if( loadBalancerIfaceMap.get(path) == null ) {
            logger.error("No load balancer assigned to this path");
            throw new PathNotFoundException(path);
        }
        loadBalancerIfaceMap.remove( path );
        return true;
    }
}
