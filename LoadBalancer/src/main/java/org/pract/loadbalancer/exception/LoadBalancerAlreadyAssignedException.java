package org.pract.loadbalancer.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoadBalancerAlreadyAssignedException extends RuntimeException {
    String path;
}
