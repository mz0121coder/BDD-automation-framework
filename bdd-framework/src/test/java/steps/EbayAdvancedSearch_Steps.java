package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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

    // https://www.guru99.com/select-option-dropdown-selenium-webdriver.html
    @When("I search for {string} in the {string} category")
    public void iSearchForInTheCategory(String str1, String str2) {
        driver.findElement(By.id("_nkw")).sendKeys(str1);
        Select categories = new Select(driver.findElement(By.id("s0-1-17-4[0]-7[3]-_sacat")));

        categories.selectByVisibleText(str2);

        WebElement searchBtn = driver.findElement(By.cssSelector("body > div.page-grid-container > div > main > form > fieldset.adv-fieldset__keyword > div.field.adv-keywords__btn-help > button"));
        searchBtn.click();
    }

    @Then("I confirm at least {int} search results are present")
    public void iConfirmAtLeastSearchResultsArePresent(int count) {
        List<WebElement> resultDivs = driver.findElements(By.cssSelector(".s-item__details.clearfix"));
        int resultCount = resultDivs.size();
        System.out.println(resultCount);

        if (resultCount < count) fail("Not enough results");
    }
}
