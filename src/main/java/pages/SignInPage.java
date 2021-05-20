package pages;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

public final class SignInPage extends BasicPage {

  public void isLoaded() {
    textIsVisible("Welcome Back");
  }

  public void fillEmail(String value) {
    $(By.id("email")).setValue(value);
  }

  public void fillPassword(String value) {
    $(By.id("password")).setValue(value);
  }
}
