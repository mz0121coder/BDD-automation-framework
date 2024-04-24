package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Common_Steps {
    private WebDriver driver;

    //import from cucumber.java, not junit
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //import from cucumber.java, not junit
    @After
    public void tearDown() {
        driver.quit();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
