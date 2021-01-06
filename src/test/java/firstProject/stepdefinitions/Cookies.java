package firstProject.stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Cookies {
    private boolean cookieBelly;
    private boolean belly;

    @Given("I have {int} cookies in my belly")
    public void i_have_cookies_in_my_belly(int cookies) {
        System.out.println("Given I have " + cookies + " cookies in my belly");
        if (cookies > 0) {
            cookieBelly = true;
        } else {
            cookieBelly = false;
            throw new PendingException();
        }
    }

    @When("I wait {int} hour")
    public void i_wait_hour(int hour) {
        System.out.println("I wait " + hour + " hour");
        if (hour < 0) {
            belly = false;
            throw new PendingException();
        } else {
            belly = true;
        }
    }

    @Then("my belly should growl")
    public void my_belly_should_growl() {
        System.out.println("my belly should growl");
        if (!(cookieBelly && belly)) {
            throw new PendingException();
        }
    }
}
