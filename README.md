# Gradle + jUnit5 + Cucumber + logback + Selenide + Allure reports

A sample gradle base project which uses jUnit5 for running tests, Cucumber as BDD framework, logback library for logging,
Selenide for browser manipulations and Allure framework for reporting.

# To Run

* will run all the test inside `src/test/tests`.
  ```shell
  $ gradlew clean cucumber --tests tests.* -i
  ```
* will run all the test inside `src/test/tests` on Prod env.
  ```shell
  $ gradlew clean cucumber --tests tests.* -i -Denv=prod
  ```
* will run all the test inside `src/test/tests` on Prod env in `firefox` browser.
  ```shell
  $ gradlew clean cucumber --tests tests.* -i -Denv=prod -Dbrowser=firefox
  ```

After the tests are ran, you can see:

* jUnit test reports under `build/reports/tests/index.html`
* logs from file appender under `build/logs/log.log`
* screenshots and saved page sources from Selenide `build/reports/tests`
* Allure results `build/allure-results`
* Allure report `build/reports/allure-report`

## Allure configuration

* [Allure CLI](https://docs.qameta.io/allure/#_commandline) should be installed
* Allure results stored in `build/allure-results`
* Allure report stored in `build/reports/allure-report`
* To open allure report
  ```shell
  $ allure open path_to_allure_report_folder
  ```

### Allure-Selenide

* Allure report will contain Selenide browser interaction history, screenshots/page sources for
  failing test cases

## Selenide configuration

Selenide provides a lot of things out of the box, no extra configuration required for sample
project. In case you would like to do custom configuration you can find an example in
AppConfiguration.class.

* Default browser is `chrome`
* By default Selenide puts screenshots and .html to folder `build/reports/tests`
* To change the browser you can use `-Dbrowser=firefox`

## Cucumber configuration

* Glue or steps classes `src/test/steps`
* Feature files `src/resources/features`
* Cucumber property file `src/resources/cucumber.properties`
* Example of test runner `src/test/tests/grinfer/GrinferCucumberTest.java`

## Logback configuration

You can find logback configuration here `src/test/resources/logback.xml`

Current configuration contains two appenders:

* ConsoleAppender will output logs to system out stream
* FileAppender will output logs to `build/logs/log.log` 

## Framework configuration

### Page objects

Path `src/main/pages`

### AppConfiguration

This class makes generic configuration for the framework and allows us to run tests on different
environments by passing system property.

`./gradlew clean cucumber --tests tests.* -i -Denv=prod`

### AllureEnvironmentWriter

This class adds framework configuration details to "Environments" section of Allure report

### RunContext

Represents test run context storage which allows to save/get data and share it between test
cases/test classes during test run.  

Example:  
<code>
RunContext.put("key", 123);
</code>

<code>
int value = RunContext.get("key", Integer.class);
</code>

## Libraries Used

* [Junit](https://junit.org/junit5/docs/current/user-guide/) - 5.7.0
* [Gradle](https://gradle.org/guides) - 6.8.3
* [Logback](http://logback.qos.ch/manual/index.html) - 1.2.3
* [Selenide](https://rselenide.org/documentation.html) - 5.20.1
* [Allure](https://docs.qameta.io/allure/) - 2.13.9
* [Allure-Selenide](https://selenide.org/documentation/reports.html) - 2.13.9
* [Cucumber](https://cucumber.io/docs/cucumber/) - 6.8.1
* [Allure-Cucumber](https://docs.qameta.io/allure/#_cucumber_jvm) - 2.13.9
* [Selenide wiki](https://github.com/selenide/selenide/wiki)
