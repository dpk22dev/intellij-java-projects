package org.pract.loadbalancer.service;

import lombok.NoArgsConstructor;
import org.pract.loadbalancer.model.Request;
import org.pract.loadbalancer.model.Response;

@NoArgsConstructor
public class NonBlockingService implements ServiceIface {
    @Override
    public Response serveRequest(Request request) {
        return new Response( "ok ");
    }
}
