package org.pract;

public class Greeting {
    private String hello;

    public Greeting(String hello) {
        this.hello = hello;
    }

    private String privateGreet(){
        return "shush greeting";
    }
    public static String staticGreet(){
        return "greeting anon";
    }

    public String objectGreet(String some){
        return this.hello + " greeting " + some;
    }
}
