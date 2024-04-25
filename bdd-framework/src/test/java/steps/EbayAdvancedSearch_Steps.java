package steps;

import io.cucumber.datatable.DataTable;
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
    public void iNavigateToEbayHomePage() throws InterruptedException {
        String expUrl = "https://www.ebay.com/";
        String actUrl = driver.getCurrentUrl();
        if (!expUrl.equals(actUrl)) fail("Page does not navigate to home page");
        Thread.sleep(1000);
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
    public void iConfirmAtLeastSearchResultsArePresent(int count) throws InterruptedException {
        List<WebElement> resultDivs = driver.findElements(By.cssSelector(".s-item__details.clearfix"));
        int resultCount = resultDivs.size();
        System.out.println(resultCount);

        if (resultCount < count) fail("Not enough results");
        Thread.sleep(1000);
    }

    @Given("I am on the Ebay Advanced Search Page")
    public void i_am_on_the_ebay_advanced_search_page() {
        driver.get("https://www.ebay.com/sch/ebayadvsearch");
    }

    @When("I advanced search for an item")
    public void i_advanced_search_for_an_item(DataTable dataTable) throws InterruptedException {
        WebElement keywordInput = driver.findElement(By.id("_nkw"));
        WebElement excludeWordsInput = driver.findElement(By.id("_ex_kw"));
        WebElement minPriceInput = driver.findElement(By.name("_udlo"));
        WebElement maxPriceInput = driver.findElement(By.name("_udhi"));
        WebElement searchBtn = driver.findElement(By.cssSelector("body > div.page-grid-container > div > main > form > fieldset.adv-fieldset__keyword > div.field.adv-keywords__btn-help > button"));


        keywordInput.sendKeys(dataTable.cell(1, 0));
        excludeWordsInput.sendKeys(dataTable.cell(1, 1));
        minPriceInput.sendKeys(dataTable.cell(1, 2));
        maxPriceInput.sendKeys(dataTable.cell(1, 3));
        searchBtn.click();

        Thread.sleep(1000);
    }


    @Then("There are at least {int} results")
    public void thereAreAtLeastResults(int count) {
        WebElement resultCountSpan = driver.findElement(By.cssSelector("#mainContent > div.s-answer-region.s-answer-region-center-top > div > div.clearfix.srp-controls__row-2 > div:nth-child(1) > div.srp-controls__control.srp-controls__count > h1 > span:nth-child(1)"));
        int resultCount = Integer.parseInt(resultCountSpan.getText().replace(",", ""));
        System.out.println("RESULTS: " + resultCount);
        System.out.println("MIN COUNT: " + count);
        if (resultCount < count) fail("Not enough results");
    }
}


