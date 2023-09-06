package org.pract.loadbalancer.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pract.loadbalancer.exception.LoadBalancerAlreadyAssignedException;
import org.pract.loadbalancer.service.LoadBalancerIface;
import org.pract.loadbalancer.service.RoundRobinLoadBalancer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoadBalancerRepositoryTest {

    Logger logger = LoggerFactory.getLogger(LoadBalancerRepositoryTest.class);
    ResourceBundle resourceBundle = ResourceBundle.getBundle("application");

    @InjectMocks
    private LoadBalancerRepository loadBalancerRepository;

    @Mock
    Map<String, LoadBalancerIface> pathMap;

    @Mock
    LoadBalancerIface loadBalancer;
    /*
    @BeforeAll
    void beforeAll() {
        pathMap = new ConcurrentHashMap<>();
        loadBalancerRepository = new LoadBalancerRepository( pathMap );
    }
*/
    @Test
    void addLoadBalancer_when_path_is_already_present() {
       when(pathMap.get( any() )).thenReturn( loadBalancer );
       assertThrows(LoadBalancerAlreadyAssignedException.class, () -> loadBalancerRepository.addLoadBalancer("/a", loadBalancer)  );
    }

    @Test
    void adds_load_balancer_when_path_absent() {
        when( pathMap.get( anyString()) ).thenReturn( null );
        assertTrue(loadBalancerRepository.addLoadBalancer("/a", loadBalancer));
    }
}