package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = {"src/test/resources/desgin"},
        glue = {"stepdefination","hooks"},
        tags = "@amazon01",
        plugin = {"pretty"
                ,"html:target/test-results/report.html",
                "json:target/test-results/report.json",
                "junit:target/test-results/report.xml"}
)

public class Runner {


}
