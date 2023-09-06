package org.pract.loadbalancer.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DownStreamServiceNotAvailableException extends Exception {
    String msg;
}
