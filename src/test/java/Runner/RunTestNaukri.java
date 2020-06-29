package Runner;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.CucumberOptions;

@CucumberOptions(features="src/test/java/Features/Naukri.feature",
                 glue = "Steps",
                 monochrome=true)
public class RunTestNaukri extends AbstractTestNGCucumberTests {

}
