package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.fail;

public class EbayHome_Steps {
    WebDriver driver;

    public EbayHome_Steps(Common_Steps common_steps) {
        this.driver = common_steps.getDriver();
    }

    @Given("I am on the Ebay Home Page")
    public void iAmOnTheEbayHomePage() {
        driver.get("https://www.ebay.com/");
    }

    @When("I click on the Advanced link")
    public void iClickOnTheAdvancedLink() {
        driver.findElement(By.linkText("Advanced")).click();
    }

    @Then("I navigate to the Advanced Search page")
    public void iNavigateToTheAdvancedSearchPage() {
        String expectedUrl = "https://www.ebay.com/sch/ebayadvsearch";
        String actualUrl = driver.getCurrentUrl();
        if (!expectedUrl.equals(actualUrl)) fail("Page does not navigate to expected page");
    }

    @When("I search for iphone {int}")
    public void iSearchForIphone(int arg0) {
        WebElement searchInput = driver.findElement(By.id("gh-ac"));
        searchInput.sendKeys("iphone 12");
        WebElement searchBtn = driver.findElement(By.id("gh-btn"));
        searchBtn.click();
    }

    @Then("I validate at least {int} search results are present")
    public void iValidateAtLeastSearchResultsArePresent(int arg0) {
        WebElement resultSpan = driver.findElement(By.cssSelector("#mainContent > div.s-answer-region.s-answer-region-center-top > div.srp-controls.srp-controls-v3.srp-controls--with-list.srp-controls--with-checkbox.srp-controls--resize > div.clearfix.srp-controls__row-2 > div:nth-child(1) > div.srp-controls__control.srp-controls__count > h1 > span:nth-child(1)"));
        int resultCount = Integer.parseInt(resultSpan.getText().replaceAll("\\D+", ""));
        System.out.println(resultCount);
        if (resultCount < 1000) fail("Not enough results for iphone 12");
    }
}
