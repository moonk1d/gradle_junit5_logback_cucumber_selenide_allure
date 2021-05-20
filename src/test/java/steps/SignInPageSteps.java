package steps;

import io.cucumber.java8.En;
import pages.SignInPage;

public class SignInPageSteps implements En {

  private SignInPage signInPage = new SignInPage();

  public SignInPageSteps() {
    When("I fill email field with {string} value", (String value) -> signInPage.fillEmail(value));
    When("I fill password field with {string} value",
        (String value) -> signInPage.fillPassword(value));
  }

}
