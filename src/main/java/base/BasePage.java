package base;

import Helpers.*;
import org.apache.log4j.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import setup.DriverSetUp;

public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {

    public static final Logger LOGGER = Logger.getLogger(BasePage.class);
    protected WebDriver driver;
    protected static final String BASE_URL = System.getProperty("selenium.url", "https://tree.taiga.io/");


    public BasePage() {
        this.driver = DriverSetUp.get().getDriver();
        PageFactory.initElements(driver, this);
    }

    public abstract String getUrl();

    public T initPage() {
        PageFactory.initElements(DriverSetUp.get().getDriver(), this);
        LOGGER.info("Initialising to " + DriverSetUp.get().getDriver().getCurrentUrl());
        return (T) this;
    }

    protected void open() {
        openByURL(getUrl());
    }

    protected void openByURL(String url) {
        LOGGER.info("Opening URL -> " + url);
        DriverSetUp.get().getDriver().get(url);
    }

    protected boolean isDisplayed(WebElement element) {
        try {
            LOGGER.info("Making sure that element is displayed -> " + element.toString());
            WaitHelper.getInstance().WaitForElementToBeDisplayed(element);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void type(WebElement element, String text) {
        LOGGER.info("Typing " + text + " in -> " + element.toString());
        WaitHelper.getInstance().WaitForElementToBeDisplayed(element);
        element.sendKeys(text);
    }

    protected void click(WebElement element) {
        LOGGER.info("Clicking on -> " + element.toString());
        WaitHelper.getInstance().WaitForElementToBeDisplayed(element);
        element.click();
    }


}
