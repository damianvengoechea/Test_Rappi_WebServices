package co.com.rappitestqaengineer.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/services_test.feature",
        glue = "co.com.rappitestqaengineer.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)

public class ServicesTest {
}
