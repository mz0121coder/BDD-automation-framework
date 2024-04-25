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
    public void iNavigateToTheAdvancedSearchPage() throws InterruptedException {
        String expectedUrl = "https://www.ebay.com/sch/ebayadvsearch";
        String actualUrl = driver.getCurrentUrl();
        if (!expectedUrl.equals(actualUrl)) fail("Page does not navigate to expected page");
        Thread.sleep(1000);
    }

    @When("I search for {string}")
    public void iSearchForIphone(String str) {
        WebElement searchInput = driver.findElement(By.id("gh-ac"));
        searchInput.sendKeys(str);
        WebElement searchBtn = driver.findElement(By.id("gh-btn"));
        searchBtn.click();
    }

    @Then("I validate at least {int} search results are present")
    public void iValidateAtLeastSearchResultsArePresent(int count) throws InterruptedException {
        WebElement resultSpan = driver.findElement(By.cssSelector("#mainContent > div.s-answer-region.s-answer-region-center-top > div.srp-controls.srp-controls-v3.srp-controls--with-list.srp-controls--with-checkbox.srp-controls--resize > div.clearfix.srp-controls__row-2 > div:nth-child(1) > div.srp-controls__control.srp-controls__count > h1 > span:nth-child(1)"));
        int resultCount = Integer.parseInt(resultSpan.getText().replaceAll("\\D+", ""));
        System.out.println(resultCount);
        if (resultCount < count) fail("Not enough search results");
        Thread.sleep(1000);
    }

    @When("I click on {string}")
    public void i_click_on(String string) throws InterruptedException {
        driver.findElement(By.linkText(string)).click();
        Thread.sleep(1000);
    }

    @Then("I navigate to {string} and page title contains {string}")
    public void i_navigate_to_and_page_title_contains(String url, String title) {
        String actUrl = driver.getCurrentUrl();
        String actTitle = driver.getTitle();
        if (!actUrl.equals(url)) fail("Page does not navivate to expected url: " + url);
        if (!actTitle.contains(title)) fail("Page title does not contain expected title: " + title);
    }

}
