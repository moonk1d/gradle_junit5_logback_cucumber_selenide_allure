package steps;

import static com.codeborne.selenide.Selenide.open;

import ch.qos.logback.classic.Logger;
import com.codeborne.selenide.logevents.SelenideLogger;
import common.Page;
import io.cucumber.java8.En;
import io.qameta.allure.Allure;
import java.util.concurrent.TimeUnit;
import org.slf4j.LoggerFactory;
import pages.BasicPage;

public class GenericSteps implements En {

  private static final Logger logger = (Logger) LoggerFactory.getLogger(GenericSteps.class);

  BasicPage basicPage = new BasicPage();

  public GenericSteps() {

    Given("I open {string} page", (String page) -> open(Page.valueOf(page).getUrl()));

    When("I click {string} link",
        (String linkText) -> basicPage.clickLinkByText(linkText));

    When("I click {string} button",
        (String linkText) -> basicPage.clickButtonByText(linkText));

    When("I wait for {int} seconds",
        (Integer secondsToWait) -> {
          try {
            TimeUnit.SECONDS.sleep(secondsToWait);
          } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
          }
        });

    Then("I see {string} page",
        (String page) -> Page.valueOf(page).getClazz().getDeclaredConstructor().newInstance()
            .isLoaded());
  }
}
