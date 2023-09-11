package org.pract.bdd;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.pract.EvenOddBddExample;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class EvenOddStepdefs {
    private EvenOddBddExample evenOddBddExample;

    String result;
    @Given("Create the even odd check instance")
    public void createTheEvenOddCheckInstance() {
        evenOddBddExample = new EvenOddBddExample();
    }

    @When("I will pass {int}")
    public void iWillPass(int arg0) {
        result = evenOddBddExample.check(arg0);
    }

    @Then("output should be {string}")
    public void outputShouldBe(String arg0) {
        assertEquals(arg0,result);
    }
}

