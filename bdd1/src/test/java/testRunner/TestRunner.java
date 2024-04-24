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
//        dryRun=true
//        Only run scenario with specified tag
//        tags = "@A2"
//        Only run scenarios containing name
//        name = {"Logo"}
)
public class TestRunner {

}
