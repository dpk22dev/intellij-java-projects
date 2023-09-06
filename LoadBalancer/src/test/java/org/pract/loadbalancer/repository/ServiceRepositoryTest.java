package org.pract.loadbalancer.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pract.loadbalancer.exception.ServiceNotFoundException;
import org.pract.loadbalancer.service.ServiceIface;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServiceRepositoryTest {

    @Mock
    Map<String, ServiceIface> serviceMap;

    @InjectMocks
    ServiceRepository serviceRepository;

    @Mock
    ServiceIface serviceIface;

    @Test
    void getService_when_not_registered() {
        when( serviceMap.get( anyString() ) ).thenReturn( null );
        assertThrows( ServiceNotFoundException.class, () -> serviceRepository.getService("/a"));
    }
}