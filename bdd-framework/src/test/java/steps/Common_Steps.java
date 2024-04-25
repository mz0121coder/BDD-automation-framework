package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Common_Steps {
    private WebDriver driver;

    //import from cucumber.java, not junit
    @Before(order = 1)
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Global Before Hook executed");
    }

    //import from cucumber.java, not junit
    @After(order = 0)
    public void tearDown() {
        System.out.println("Global after hook executed");
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
