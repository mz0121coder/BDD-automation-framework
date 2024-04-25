package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Tagged_Hooks {
    WebDriver driver;

    public Tagged_Hooks(Common_Steps common_steps) {
        driver = common_steps.getDriver();
    }

    // Just for practice - scenarios with @setCookies will execute this hook
//    for @Before, higher priority (at top of order) is executed first
    @Before(value = "@setCookies", order = 0)
    public void setCookies() {
        System.out.println("Scenario specific hook - setCookies executed");
    }

    // Just for practice - scenarios with @Test will execute this hook
//    for @After, higher priority (at top of order) is executed last
    @After(value = "@Test", order = 1)
    public void testAfterHook() {
        System.out.println("Scenario specific hook - testAfterHook executed");
    }

    public WebDriver getDriver() {
        return driver;
    }
}
