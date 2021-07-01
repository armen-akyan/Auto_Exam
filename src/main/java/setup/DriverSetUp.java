package setup;

import base.BasePage;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetUp {

    private WebDriver driver;
    private static final String BROWSER = System.getProperty("selenium.browser", "remote");
    private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    public static DriverSetUp get() {
        return new DriverSetUp();
    }


    public WebDriver getDriver() {
        if (driverThread.get() == null) {
            switch (BROWSER) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver",
                            "src/test/resources/chromedriver");
                    driver = new ChromeDriver();
                    driverThread.set(driver);
                    break;

                case "firefox":
                    System.setProperty("webdriver.gecko.driver",
                            "src/test/resources/geckodriver");
                    driver = new FirefoxDriver();
                    driverThread.set(driver);
                    break;

                case "safari":
                    driver = new SafariDriver();
                    driverThread.set(driver);
                    break;

                case "remote":
                    try {
                        DesiredCapabilities capabilities = new DesiredCapabilities();
                        capabilities.setBrowserName("chrome");
                        capabilities.setCapability("enableVNC", true);
                        driver = new RemoteWebDriver(new URL("http://localhost:8080/wd/hub"), capabilities);
                        driverThread.set(driver);
                        break;
                    } catch (Exception exception) {
                        System.out.println(exception);
                    }
            }
        }
        return driverThread.get();
    }

    public void quit() {
        getDriver().quit();
        driverThread.remove();
    }

}
