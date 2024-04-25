package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayHome_Elements {
    WebDriver driver;
    //    advanced search link
    @FindBy(linkText = "Advanced")
    public WebElement advancedSearchLink;
    //    search input
    @FindBy(id = "gh-ac")
    public WebElement searchInput;
    // search button
    @FindBy(id = "gh-btn")
    public WebElement searchBtn;
    //    result span
    @FindBy(css = "#mainContent > div.s-answer-region.s-answer-region-center-top > div.srp-controls.srp-controls-v3.srp-controls--with-list.srp-controls--with-checkbox.srp-controls--resize > div.clearfix.srp-controls__row-2 > div:nth-child(1) > div.srp-controls__control.srp-controls__count > h1 > span:nth-child(1)")
    public WebElement resultSpan;

    public EbayHome_Elements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
