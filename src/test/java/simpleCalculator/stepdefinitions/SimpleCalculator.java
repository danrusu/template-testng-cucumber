package simpleCalculator.stepdefinitions;

import common.ui.webdriver.WebDriverStrategy;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Optional;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

public class SimpleCalculator {

    private WebDriver webDriver;

    @Before
    public void setupDriver() {
        webDriver = WebDriverStrategy.valueOf("CHROME").getDriver();
    }

    @Given("User is on Simple Calculator page")
    public void user_is_on_Simple_Calculator_page() {
        webDriver.get("http://qatools.ro/calculate/appApi.html");
    }

    @When("User types {string} in Number1 input")
    public void user_types_in_Number1_input(final String number1) {
        webDriver.findElement(By.id("nr1")).sendKeys(number1);
    }

    @When("User types {string} in Number2 input")
    public void user_types_in_Number2_input(final String number2) {
        webDriver.findElement(By.id("nr2")).sendKeys(number2);
    }

    @When("User selects {string} operation from dropdown")
    public void user_selects(final String operation) {
        webDriver.findElement(By.cssSelector("select")).click();
        webDriver.findElement(By.xpath(
                String.format("//option[contains(text(), \"%s\")]", operation))
        ).click();
    }

    @When("User presses the CALCULATE button")
    public void user_presses_the_CALCULATE_button() {
        webDriver.findElement(By.cssSelector("button[name=\"calculate\"]")).click();
    }

    @Then("Result should display {string}")
    public void result_should_display(final String expectedResult) {
        new WebDriverWait(webDriver, 3)
                .until(textToBe(
                        By.cssSelector("[data-qa-test=\"result\"]"),
                        expectedResult));
    }

    @After
    public void quitDriver() {
        Optional.ofNullable(webDriver).ifPresent(driver -> driver.quit());
    }

}