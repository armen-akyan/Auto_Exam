import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.DriverSetUp;

public class LoginTest {
    @BeforeMethod
    public void drive() {
        DriverSetUp.getDriver();
    }

    @AfterMethod
    public void endDrive() {
        DriverSetUp.quit();
    }

    @Test
    public static void loginWithValidCredentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername(BasePage.USERNAME);
        loginPage.enterPassword(BasePage.PASSWORD);
        loginPage.clickLogInButton();

        Thread.sleep(2000);
        Assert.assertTrue(new ProjectsViewerPage().isProfileIconDisplayed(), "Error while Logging in");
    }

    @Test
    public void loginWithInvalidCredentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername(BasePage.USERNAME);
        loginPage.enterPassword(BasePage.PASSWORD);
        loginPage.clickLogInButton();

        Thread.sleep(2000);
        Assert.assertTrue(loginPage.initPage().isErrorAlertDisplayed(), "Error alert is not displayed");
    }
}
