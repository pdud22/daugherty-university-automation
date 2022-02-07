import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//        plugin = {
//                "pretty",
//                "html:target/cucumber-report.html",
//                "json:target/cucumber.json"
//        },
        features = {"src/test/resources/features/"}
)
public class MainRunnerTestJUnit extends AbstractTestNGCucumberTests {
}
