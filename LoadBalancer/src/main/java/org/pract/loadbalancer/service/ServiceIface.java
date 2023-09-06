package org.pract.loadbalancer.service;

import org.pract.loadbalancer.exception.DownStreamServiceNotAvailableException;
import org.pract.loadbalancer.model.Request;
import org.pract.loadbalancer.model.Response;

public interface ServiceIface {
    public Response serveRequest(Request request) throws DownStreamServiceNotAvailableException;
}
