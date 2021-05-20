package tests.dummy;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import tests.BaseTest;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources/features/dummy"},
    glue = {"steps"},
    plugin = {
        "pretty",
        "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
    })

public class DummyCucumberTest extends BaseTest {

}
