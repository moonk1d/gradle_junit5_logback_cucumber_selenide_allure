package utils;

import static java.lang.System.getProperty;
import static java.util.Optional.ofNullable;

import ch.qos.logback.classic.Logger;
import com.codeborne.selenide.Configuration;
import configuration.AppConfiguration;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.slf4j.LoggerFactory;

public final class AllureEnvironmentWriter {

  private static final Logger logger = (Logger) LoggerFactory.getLogger(AppConfiguration.class);
  private static final String PROPERTIES_PATH = "build/allure-results/environment.properties";

  public static void writeEnvironment() {

    try (FileOutputStream fos = new FileOutputStream(PROPERTIES_PATH);) {
      Properties props = new Properties();

      ofNullable(getProperty("env")).ifPresent(s -> props.setProperty("Environment:", s));
      props.setProperty("Base url:", AppConfiguration.getEnvironment().getUrl());
      props.setProperty("Browser:", Configuration.browser);

      props.store(fos, "Writing properties to output stream");

    } catch (IOException e) {
      logger.error("Not able to write property file", e);
    }
  }
}
