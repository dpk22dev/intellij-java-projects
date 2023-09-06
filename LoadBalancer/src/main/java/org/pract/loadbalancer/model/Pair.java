package org.pract.loadbalancer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class Pair<P, Q> {
    P first;
    Q second;
}
