package setup;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetUp {

    private WebDriver driver;
    private static final String BROWSER = System.getProperty("selenium.browser", "firefox");
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

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
            }
        }
        return driverThread.get();
    }
    public static void quit() {
        driverThread.get().quit();
        driverThread.remove();
    }

}
