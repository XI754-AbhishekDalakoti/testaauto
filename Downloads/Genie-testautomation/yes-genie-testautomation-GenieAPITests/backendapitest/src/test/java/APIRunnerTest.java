import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
//@CucumberOptions(features="src/test/resources/apiFeatures/")

@CucumberOptions(
        features =  "src/test/resources/apiFeatures/search.feature"
)

public class APIRunnerTest {

}
