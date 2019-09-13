package Selenoid;

import auto_test_task2.GeneralBase;
import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class SolenoidDriver implements WebDriverProvider {
  @Override
  public WebDriver createDriver (DesiredCapabilities capabilities) {
    DesiredCapabilities browser = new DesiredCapabilities();
    browser.setBrowserName("chrome");
    browser.setVersion("75.0");
    browser.setCapability("enableVNC", true);
    browser.setCapability("enableVideo", false);
    browser.setCapability("browserConnectionEnabled", true);

    RemoteWebDriver driver = null;
    try {
      driver = new RemoteWebDriver(
              URI.create("http://localhost:4444/wd/hub").toURL(),browser);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }

    return driver;
  }
}
