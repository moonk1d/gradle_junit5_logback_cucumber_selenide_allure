package configuration;

import ch.qos.logback.classic.Logger;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.base.Strings;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import java.util.logging.Level;
import org.slf4j.LoggerFactory;

public final class AppConfiguration {

  private static final Logger logger = (Logger) LoggerFactory.getLogger(AppConfiguration.class);
  private static Environment environment;
  private static final String DEFAULT_BROWSER = "chrome";

  public static Environment getEnvironment() {
    return environment;
  }

  public static void initialize() {
    setupEnvironment();
    setupSelenideConfiguration();
  }

  private static void setupSelenideConfiguration() {
    logger.info("Configuring Selenide");
    String browser = System.getProperty("browser");
    if (!Strings.isNullOrEmpty(browser)) {
      Configuration.browser = browser;
    } else {
      Configuration.browser = DEFAULT_BROWSER;
    }
    Configuration.startMaximized = true;
    Configuration.baseUrl = environment.getUrl();

    logger.info("Configuring AllureSelenide");
    AllureSelenide allureSelenide = new AllureSelenide();
    allureSelenide.enableLogs(LogType.BROWSER, Level.ALL);
    SelenideLogger.addListener("AllureSelenide", allureSelenide);
  }

  private static void setupEnvironment() {
    String envProperty = System.getProperty("env");

    if (envProperty == null) {
      envProperty = "default";
    }

    switch (envProperty) {
      case "prod":
        environment = Environment.PROD;
        break;
      case "test":
        environment = Environment.TEST;
        break;
      default:
        // TODO: Add default environment
        environment = Environment.PROD;
        break;
    }

    logger.info("Setting up environment URL as [{}]", environment.getUrl());
  }
}
