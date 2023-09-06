package org.pract.loadbalancer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.pract.loadbalancer.service.ServiceIface;

@AllArgsConstructor
@Getter
public class ServiceRegistrationRequest {
    private String path;
    private ServiceIface serviceIface;
}
