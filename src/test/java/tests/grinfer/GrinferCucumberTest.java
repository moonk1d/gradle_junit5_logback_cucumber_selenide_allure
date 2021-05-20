package tests.grinfer;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import tests.BaseTest;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources/features/grinfer"},
    glue = {"steps"},
    plugin = {
        "pretty",
        "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
    })

public class GrinferCucumberTest extends BaseTest {

}
