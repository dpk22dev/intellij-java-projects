package org.pract.loadbalancer.repository;

import org.pract.loadbalancer.exception.PathNotFoundException;
import org.pract.loadbalancer.exception.ServiceNotFoundException;
import org.pract.loadbalancer.model.ServiceRegistrationRequest;
import org.pract.loadbalancer.service.ServiceIface;

import java.util.ArrayList;
import java.util.Map;

public class ServiceRepository {

    Map<String, ServiceIface> serviceMap;

    public ServiceRepository(Map<String, ServiceIface> serviceMap) {
        this.serviceMap = serviceMap;
    }

    public boolean unregisterService(ServiceRegistrationRequest serviceRegistrationRequest) {
        String path = serviceRegistrationRequest.getPath();
        ServiceIface serviceIface = serviceRegistrationRequest.getServiceIface();
        serviceMap.computeIfAbsent( path, k -> { throw new PathNotFoundException( k ); });
        serviceMap.remove( path );
        return true;
    }

    public boolean registerService(ServiceRegistrationRequest serviceRegistrationRequest) {
        String path = serviceRegistrationRequest.getPath();
        ServiceIface serviceIface = serviceRegistrationRequest.getServiceIface();
        serviceMap.put( path, serviceIface);
        return true;
    }

    public ServiceIface getService(String path) {
        if( serviceMap.get(path) == null ){
            throw new ServiceNotFoundException(path);
        }
        return serviceMap.get( path );
    }
}
