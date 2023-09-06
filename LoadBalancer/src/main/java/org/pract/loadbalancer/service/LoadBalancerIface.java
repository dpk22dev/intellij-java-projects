package org.pract.loadbalancer.service;

import org.pract.loadbalancer.exception.DownStreamServiceNotAvailableException;
import org.pract.loadbalancer.exception.LoadBalancerAlreadyAssignedException;
import org.pract.loadbalancer.exception.PathNotFoundException;
import org.pract.loadbalancer.model.Request;
import org.pract.loadbalancer.model.Response;
import org.pract.loadbalancer.model.ServiceRegistrationRequest;

import javax.management.ServiceNotFoundException;

public interface LoadBalancerIface {
    boolean registerLoadBalancer( String path, AbstractLoadBalancer loadBalancer) throws PathNotFoundException, LoadBalancerAlreadyAssignedException;
    boolean registerService(ServiceRegistrationRequest serviceRegistrationRequest ) throws PathNotFoundException;

    boolean unregisterService(ServiceRegistrationRequest serviceRegistrationRequest ) throws PathNotFoundException, ServiceNotFoundException;
    Response processRequest(Request request) throws PathNotFoundException, DownStreamServiceNotAvailableException;
}
