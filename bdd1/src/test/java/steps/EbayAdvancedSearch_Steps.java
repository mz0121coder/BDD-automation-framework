package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.fail;

public class EbayAdvancedSearch_Steps {
    WebDriver driver;

    public EbayAdvancedSearch_Steps(Common_Steps common_steps) {
        this.driver = common_steps.getDriver();
    }

    @Given("I am on Ebay Advanced Search Page")
    public void iAmOnEbayAdvancedSearchPage() {
        driver.get("https://www.ebay.com/sch/ebayadvsearch");
    }

    @When("I click on Ebay Logo")
    public void iClickOnEbayLogo() {
        driver.findElement(By.id("gh-la")).click();
    }

    @Then("I navigate to Ebay Home Page")
    public void iNavigateToEbayHomePage() {
        String expUrl = "https://www.ebay.com/";
        String actUrl = driver.getCurrentUrl();
        if (!expUrl.equals(actUrl)) fail("Page does not navigate to home page");
    }
}
