package org.pract;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

/*
to demonstrate features of mock testing
 */

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    // annotation based init
    /*
    It is not recommended to use field or setter injection. Using constructor injection,
    we can be 100% sure no one instantiates the class without injecting its dependencies.
     */

    /*
    Imp:
    @Mock creates a mock. @InjectMocks creates an instance of the class and
    injects the mocks that are created with the @Mock (or @Spy) annotations into this instance.
     */

    @Mock
    UserService mockedUserService;
    private AutoCloseable closeable;

    @BeforeEach
    void initService() {
        // scan and mark any annotations with @mock
        // not required due to MockitoExtension
        //closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void closeService() throws Exception {
        // not required due to MockitoExtension
        //closeable.close();
    }

    @Test
    void mockList() {
        // mocking by  method name
        List myList = mock( List.class );
        when(myList.add( anyString() )).thenReturn(false);

        assertFalse( myList.add("x") );
    }

    @Test
    void userServiceGetAlbert() {
        when( mockedUserService.getAlbert() ).thenReturn("tom n jerry");
        assertEquals(mockedUserService.getAlbert(), "tom n jerry" );
    }

    @Test
    void mockAsMethodParam( @Mock UserService userService ) {

    }
}
