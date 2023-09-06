package org.pract.loadbalancer.service;

import org.pract.loadbalancer.exception.LoadBalancerAlreadyAssignedException;
import org.pract.loadbalancer.exception.PathNotFoundException;
import org.pract.loadbalancer.model.ServiceRegistrationRequest;
import org.pract.loadbalancer.repository.LoadBalancerRepository;
import org.pract.loadbalancer.repository.ServiceRepository;

import javax.management.ServiceNotFoundException;

public abstract class AbstractLoadBalancer implements LoadBalancerIface{

    LoadBalancerRepository loadBalancerRepository;
    ServiceRepository serviceRepository;
    @Override
    public boolean registerLoadBalancer(String path, AbstractLoadBalancer loadBalancer) throws PathNotFoundException, LoadBalancerAlreadyAssignedException {
        return loadBalancerRepository.addLoadBalancer( path, loadBalancer);
    }

    public boolean unregisterLoadBalancer(String path, AbstractLoadBalancer loadBalancer) throws PathNotFoundException {
        return loadBalancerRepository.removeLoadBalancer( path, loadBalancer );
    }

    @Override
    public boolean registerService(ServiceRegistrationRequest serviceRegistrationRequest) throws PathNotFoundException {
        return serviceRepository.registerService(serviceRegistrationRequest);
    }

    @Override
    public boolean unregisterService(ServiceRegistrationRequest serviceRegistrationRequest) throws PathNotFoundException, ServiceNotFoundException {
        return serviceRepository.unregisterService(serviceRegistrationRequest);
    }

}
