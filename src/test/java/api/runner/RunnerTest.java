package api.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.Tag;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)

@CucumberOptions( features = "src/test/resources/api/features",
        glue = "api.stepdefs",
        snippets = CucumberOptions.SnippetType.CAMELCASE)

public class RunnerTest {
}


