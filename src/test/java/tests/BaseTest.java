package tests;

import configuration.AppConfiguration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import utils.AllureEnvironmentWriter;

public class BaseTest {

  @BeforeClass
  public static void setUp() {
    AppConfiguration.initialize();
  }

  @AfterClass
  public static void tierDown() {
    AllureEnvironmentWriter.writeEnvironment();
  }

}
