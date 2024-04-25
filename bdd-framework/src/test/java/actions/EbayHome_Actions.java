package actions;

import elements.EbayHome_Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import steps.Common_Steps;

public class EbayHome_Actions {
    private WebDriver driver;
    EbayHome_Elements ebay_home_elements;

    public EbayHome_Actions(Common_Steps common_steps) {
        this.driver = common_steps.getDriver();
        ebay_home_elements = new EbayHome_Elements(driver);
    }

    public void clickAdvancedLink() {
        ebay_home_elements.advancedSearchLink.click();
    }

    public void searchForItem(String searchStr) {
        ebay_home_elements.searchInput.sendKeys(searchStr);
        ebay_home_elements.searchBtn.click();
    }

    public int countSearchResults() {
        return Integer.parseInt(ebay_home_elements.resultSpan.getText().replaceAll("\\D+", ""));
    }

    public void navigateToSection(String sectionName) {
        driver.findElement(By.linkText(sectionName)).click();
    }
}
