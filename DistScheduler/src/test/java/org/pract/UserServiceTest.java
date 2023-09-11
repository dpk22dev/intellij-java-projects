package org.pract;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pract.exception.UserAlreadyExistsException;

import java.util.List;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

    private AutoCloseable closeable;

// define classes here itself to test such cases start
// If you don't mark static below classes
// Cannot instantiate @InjectMocks field named 'calculator'!
// Cause: the type 'Calculator' is an inner non static class.
    static class RandomGenerator{
        public int giveMeNumber(){
            return 0;
        }
    }

    static class Calculator{
        RandomGenerator rg;
        Calculator(){
            rg = new RandomGenerator();
        }

        public int addRandomNumbers(){
            int x = rg.giveMeNumber();
            int y = rg.giveMeNumber();
            return x + y;
        }
    }

// // define classes here itself to test such cases ends

    @Mock
    RandomGenerator randomGenerator;

    @InjectMocks
    Calculator calculator;

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
        assertEquals(userService.getAlbert(), "albert einstein" );
    }


    @Test
    void randomSum() {
        when( randomGenerator.giveMeNumber() ).thenReturn(9);
        int x = calculator.addRandomNumbers();
        assertEquals(x,18);
    }

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    void addUserTest() {
        when( userRepository.addUser( anyString() )).thenReturn( true );
        boolean x = userService.addUser("abc");
        assertTrue( x );
    }

    @Test
    void mockSampleOne() {
        // mocking by  method name
        when( userRepository.addUser( anyString() )).thenAnswer( i -> {
            i.getArgument(0);
            return true;
        } );
        assertTrue( userRepository.addUser("alpha"));
    }

    @Test
    void checkException() {
        when( userRepository.addUser(anyString()) ).thenThrow( UserAlreadyExistsException.class );
        assertThrowsExactly( UserAlreadyExistsException.class, () -> userService.addUser("abc"));
    }

    @Test
    void staticMethodCheck() {
        // below doesn't work as getUserWithSalutation is static method
        //when( UserRepository.getUserWithSalutation( anyString() ) ).thenReturn("Mr " + ArgumentMatchers.anyString() );
        // important to close resource so do it in try block
        try (MockedStatic<UserRepository> userRepositoryMockedStatic = Mockito.mockStatic(UserRepository.class)) {
            userRepositoryMockedStatic.when(UserRepository::getBohr).thenReturn("Mr Neils Bohr");
            assertEquals(userService.getBohr(), "Mr Neils Bohr");
        }
    }

    @Test
    void staticReturnMethod() {
        try(MockedStatic<UserRepository> userRepositoryMockedStatic = Mockito.mockStatic(UserRepository.class)){
            userRepositoryMockedStatic.when(()->UserRepository.getUserWithSalutation("alpha"))
                    .thenReturn("Mr alpha");
            assertEquals( userService.getSalutedUser("alpha"), "Mr alpha" );
        }
    }

    @Test
    void addUserTestReturn() {
        doReturn(true).when( userRepository ).addUser("alpha");
        assertEquals( true, userService.addUser("alpha"));
        //when(flowerService.isABigFlower(eq("poppy"), anyInt())).thenReturn(true);
        // another way to do above
        when( userRepository.addUser( eq("alpha") ) ).thenReturn(true );
        assertTrue( userService.addUser("alpha") );

    }
}
