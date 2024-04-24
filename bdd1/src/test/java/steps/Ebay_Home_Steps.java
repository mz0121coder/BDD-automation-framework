package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Ebay_Home_Steps {
    @Given("I am on the Ebay Home Page")
    public void iAmOnTheEbayHomePage() {
        System.out.println("test");
    }

    @When("I click on the Advanced link")
    public void iClickOnTheAdvancedLink() {
        System.out.println("test");
    }

    @Then("I navigate to the Advanced Search page")
    public void iNavigateToTheAdvancedSearchPage() {
        System.out.println("test");
    }
}
