package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayAdvancedSearch_Elements {

    WebDriver driver;

    @FindBy(xpath = "//a[@id='gh-la']")
    public WebElement ebayLogo;
    @FindBy(xpath = "//input[@id='_nkw']")
    public WebElement searchString;
    @FindBy(xpath = "//input[@id='_ex_kw']")
    public WebElement excludeString;
    @FindBy(xpath = "//input[@name='_udlo']")
    public WebElement minPrice;
    @FindBy(xpath = "//input[@name='_udhi']")
    public WebElement maxPrice;
    @FindBy(xpath = "//html/body/div[2]/div/main/form/fieldset[1]/div[5]/button")
    public WebElement searchBtn;

    public EbayAdvancedSearch_Elements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
