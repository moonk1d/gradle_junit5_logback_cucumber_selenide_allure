package common;

import pages.BasicPage;
import pages.HomePage;
import pages.SignInPage;

public enum Page {
  HOME("", HomePage.class),
  LOGIN("/sign-in", SignInPage.class);

  private final String url;
  private final Class<? extends BasicPage> clazz;

  Page(String url, Class<? extends BasicPage> clazz) {
    this.url = url;
    this.clazz = clazz;
  }

  public String getUrl() {
    return url;
  }

  public Class<? extends BasicPage> getClazz() {
    return clazz;
  }
}
