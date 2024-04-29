package actions;

import elements.EbayAdvancedSearch_Elements;
import org.openqa.selenium.WebDriver;
import steps.Common_Steps;

public class EbayAdvancedSearch_Actions {

    private WebDriver driver;
    EbayAdvancedSearch_Elements ebayadvancedsearch_elements;

    public EbayAdvancedSearch_Actions(Common_Steps common_steps) {
        this.driver = common_steps.getDriver();
        ebayadvancedsearch_elements = new EbayAdvancedSearch_Elements(driver);
    }

    public void clickOnEbayLogo() {
        ebayadvancedsearch_elements.ebayLogo.click();
    }

    public void enterSearchString(String string) {
        ebayadvancedsearch_elements.searchString.sendKeys(string);
    }

    public void enterExcludeString(String string) {
        ebayadvancedsearch_elements.excludeString.sendKeys(string);
    }

    public void enterMinPrice(String string) {
        ebayadvancedsearch_elements.minPrice.sendKeys(string);
    }

    public void enterMaxPrice(String string) {
        ebayadvancedsearch_elements.maxPrice.sendKeys(string);
    }

    public void clickOnSearchBtn() {
        ebayadvancedsearch_elements.searchBtn.click();
    }

}