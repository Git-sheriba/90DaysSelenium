package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/java/Features/CarWale.feature",
                 glue = "Steps",
              //   dryRun=true,
                 monochrome=true)
               //  snippets=SnippetType.CAMELCASE)

public class RunTest extends AbstractTestNGCucumberTests{

}