package org.pract.loadbalancer.service;

import org.pract.loadbalancer.exception.DownStreamServiceNotAvailableException;
import org.pract.loadbalancer.exception.PathNotFoundException;
import org.pract.loadbalancer.model.Request;
import org.pract.loadbalancer.model.Response;
import org.pract.loadbalancer.repository.LoadBalancerRepository;
import org.pract.loadbalancer.repository.ServiceRepository;


public class RoundRobinLoadBalancer extends AbstractLoadBalancer{

    public RoundRobinLoadBalancer(LoadBalancerRepository loadBalancerRepository, ServiceRepository serviceRepository) {
        super();
        this.loadBalancerRepository = loadBalancerRepository;
        this.serviceRepository = serviceRepository;
    }

    @Override
    public Response processRequest(Request request) throws PathNotFoundException, DownStreamServiceNotAvailableException {
        String path = request.getPath();
        ServiceIface service = serviceRepository.getService(path);
        if( service == null ){
            throw new PathNotFoundException(path);
        }
        return service.serveRequest( request );
    }
}
