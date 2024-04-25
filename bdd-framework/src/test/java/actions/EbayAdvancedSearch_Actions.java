package actions;

import elements.EbayAdvancedSearch_Elements;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import steps.Common_Steps;

public class EbayAdvancedSearch_Actions {
    WebDriver driver;
    EbayAdvancedSearch_Elements ebay_advanced_search_elements;

    public EbayAdvancedSearch_Actions(Common_Steps common_steps) {
        this.driver = common_steps.getDriver();
        ebay_advanced_search_elements = new EbayAdvancedSearch_Elements(driver);
    }

    public void clickEbayLogo() {
        ebay_advanced_search_elements.ebayLogo.click();
    }

    public void searchForItemInCategory(String item, String category) {
        ebay_advanced_search_elements.searchInput.sendKeys(item);
        ebay_advanced_search_elements.categories.selectByVisibleText(category);
        ebay_advanced_search_elements.searchBtn.click();
    }

    public int countSearchResultDivs() {
        return ebay_advanced_search_elements.resultDivs.size();
    }

    public void advancedSearch(DataTable dataTable) throws InterruptedException {
        ebay_advanced_search_elements.keywordInput.sendKeys(dataTable.cell(1, 0));
        ebay_advanced_search_elements.excludeWordsInput.sendKeys(dataTable.cell(1, 1));
        ebay_advanced_search_elements.minPriceInput.sendKeys(dataTable.cell(1, 2));
        ebay_advanced_search_elements.maxPriceInput.sendKeys(dataTable.cell(1, 3));
        ebay_advanced_search_elements.searchBtn.click();
        Thread.sleep(1000);
    }

    public int countAdvancedSearchResults() {
        String resultStr = ebay_advanced_search_elements.resultCountSpan.getText().replaceAll(",", "");
        return Integer.parseInt(resultStr);
    }
}
