package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class EbayAdvancedSearch_Elements {
    WebDriver driver;
    //    ebay logo
    @FindBy(id = "gh-la")
    public WebElement ebayLogo;
    @FindBy(id = "_nkw")
//    search input
    public WebElement searchInput;
    //    categories
    @FindBy(id = "s0-1-17-4[0]-7[3]-_sacat")
    public Select categories;
    // search button
    @FindBy(css = "body > div.page-grid-container > div > main > form > fieldset.adv-fieldset__keyword > div.field.adv-keywords__btn-help > button")
    public WebElement searchBtn;
    // search result divs
    @FindAll(@FindBy(css = ".s-item__details.clearfix"))
    public List<WebElement> resultDivs;
    //    keyword input
    @FindBy(id = "_nkw")
    public WebElement keywordInput;
    //    exclude words input
    @FindBy(id = "_ex_kw")
    public WebElement excludeWordsInput;
    //    min price input
    @FindBy(name = "_udlo")
    public WebElement minPriceInput;
    //    max price input
    @FindBy(name = "_udhi")
    public WebElement maxPriceInput;
    //    result count span
    @FindBy(css = "#mainContent > div.s-answer-region.s-answer-region-center-top > div > div.clearfix.srp-controls__row-2 > div:nth-child(1) > div.srp-controls__control.srp-controls__count > h1 > span:nth-child(1)")
    public WebElement resultCountSpan;

    public EbayAdvancedSearch_Elements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
