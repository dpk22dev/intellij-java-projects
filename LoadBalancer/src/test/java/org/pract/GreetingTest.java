package org.pract;

public class GreetingTest {

    Greeting greeting;


    public void setUp() throws Exception {
        greeting = new Greeting("hi");
        System.out.println("settingup before all tests");
    }


    public void tearDown() throws Exception {
        System.out.println("teardown after all tests");
    }


    public void testAnonGreet() {
        String expected = "greeting anon";
        String actual = Greeting.staticGreet();
        //String actual = greeting.objectGreet("deepak");
    }




    public void testGreet() {
    }


    public void objectGreet() {
    }
}