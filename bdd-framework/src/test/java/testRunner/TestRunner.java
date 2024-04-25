package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"features"},
        glue = {"steps"},
        plugin = {"pretty", "html:latest-report.html"}
//        monochrome = true
//        Doesn't run tests, checks if any scenarios don't have a step definition
//        Useful for frameworks containing a large number of scenarios
//        Also generates template for step definitions
//        dryRun = true,
//        Only run scenario with specified tags
//        tags = "@A3"
//        tags = "@A1 or @A2"
//        tags = "@A1 and @A2"
//        Only run scenarios containing name
//        name = {"Logo"}
)
public class TestRunner {

}
