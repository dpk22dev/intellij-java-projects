package org.pract.loadbalancer.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ServiceNotFoundException extends RuntimeException {

    public ServiceNotFoundException(String path) {
        super(path);
    }
}
