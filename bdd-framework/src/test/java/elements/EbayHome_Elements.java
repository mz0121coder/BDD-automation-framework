package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EbayHome_Elements {

    WebDriver driver;

    @FindBy(linkText = "Advanced")
    public WebElement advancedLink;
    @FindBy(xpath = "//input[@id='gh-ac']")
    public WebElement searchBox;
    @FindBy(xpath = "//input[@id='gh-btn']")
    public WebElement searchButton;
    @FindBy(css = "h1.srp-controls__count-heading>span.BOLD:first-child")
    public WebElement numOfItems;
    @FindBy(xpath = "//*[@id=\"s0-1-17-4[0]-7[1]-_in_kw\"]")
    public List<WebElement> catOptions;

    public EbayHome_Elements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}