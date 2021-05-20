package pages;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

public class BasicPage {

  private final String BUTTON_BY_TEXT = "//span[text()='%s']/ancestor::button";
  private final String LINK_BY_TEXT = "//a[text()='%s']";
  private final String H1_BY_TEXT = "//h1[text()='%s']";
  private final String TITLE_BY_TEXT = "//title[text()='%s']";

  public void clickButtonByText(String text) {
    $(By.xpath(String.format(BUTTON_BY_TEXT, text))).click();
  }

  public void clickLinkByText(String text) {
    $(By.xpath(String.format(LINK_BY_TEXT, text))).click();
  }

  public void textIsVisible(String text) {
    $(By.xpath(String.format(H1_BY_TEXT, text))).shouldBe(visible);
  }

  public void titleIs(String text) {
    $(By.xpath(String.format(TITLE_BY_TEXT, text))).shouldBe(exist);
  }

  public void isLoaded() {
  }
}
