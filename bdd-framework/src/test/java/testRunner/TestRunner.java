package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"features"},
        glue = {"steps"},
        plugin = {"pretty", "html:latest-report.html"}
//        dryRun = false,
//        monochrome = true
//        tags = "@P240"
//        name = {"Logo"}
)
public class TestRunner {

}