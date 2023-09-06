package org.pract.loadbalancer.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PathNotFoundException extends RuntimeException {

    public PathNotFoundException(String path) {
        super(path);
    }
}
