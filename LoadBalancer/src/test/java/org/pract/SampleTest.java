package org.pract;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;
import java.util.*;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

/*
to demonstrate features of assertions
 */
public class SampleTest {
/*
    @BeforeEach
    void setUp() {
        System.out.println("setting up before each");
    }

    @AfterEach
    void tearDown() {
        System.out.println("after tear down each");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all tests");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all test");
    }
*/

    @Test
    void equalityCheck() {
        int x = 1, y = 1;
        assertEquals(x,y, "equality is checked");
    }

    @Test
    void inEqualityCheck() {
        int x = 1, y = 2;
        assertNotEquals(x,y, "inequality is checked");
    }

    @Test
    void booleanTest() {
        assertTrue( "hello".startsWith("h"));
    }

    @Test
    void nullCheck() {
        ArrayList<Integer> al = null;
        assertNull( al );
    }

    @Test
    void assertIterable() {
        List<String> al = Arrays.asList("a", "b", "c", "d");
        List<String> al1 = Arrays.asList("b", "a", "c", "d");
        Collections.sort( al1 );
        assertIterableEquals( al, al1);
    }

    @Test
    void arrayEqual() {
        int[] arr1 = {1,2,3};
        int[] arr2 = {2,1,3};
        Arrays.sort( arr2 );
        assertArrayEquals( arr2, arr1 );
    }

    @Test
    void objectEquality() {

        class Person{
            String fname;
            String lname;
            Person( String fname, String lname ){
                this.fname = fname;
                this.lname = lname;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Person person = (Person) o;
                return Objects.equals(fname, person.fname) && Objects.equals(lname, person.lname);
            }

            @Override
            public int hashCode() {
                return Objects.hash(fname, lname);
            }
        }

        Person p1 = new Person("john", "wick");
        Person p2 = new Person("john", "wick");

        assertEquals( p1, p2 );
        assertNotSame( p1, p2);
    }

    @Test
    void exceptionCheck() {
        class Divider{
            public float divide(int x, int y){
                return x/y;
            }
        }
        Divider divider = new Divider();
        assertThrows( ArithmeticException.class, () -> divider.divide(1,0));
    }

    @Test
    void timeout() {
        final String res = assertTimeout(Duration.ofMillis(300), () -> {
            Thread.sleep( 250 );
            return "finished";
        } );
        assertEquals( res, "finished");
    }

    @Test
    void groupedAssertions() {
        assertAll(
                () -> assertEquals("one", "one"),
                () -> assertNotEquals("a", "b")
        );
    }
}
