import Helpers.ApiHelper;
import Helpers.Infos;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.DriverSetUp;

import java.io.IOException;

public class LoginTest {
    @BeforeMethod
    public void drive() {
        DriverSetUp.get().getDriver();
    }

    @AfterMethod
    public void endDrive() {
        DriverSetUp.quit();
    }

    @Test
    public static void loginWithAPI() throws IOException {
        JsonObject jsonObject = ApiHelper.login();
        Assert.assertEquals(jsonObject.get("full_name").toString(), "\"Armen Armenakyan\"", "Login failed");
    }

    @Test
    public static void loginWithValidCredentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage().get();
        loginPage.enterUsername(Infos.USERNAME);
        loginPage.enterPassword(Infos.PASSWORD);
        loginPage.clickLogInButton();

        Thread.sleep(2000);
        Assert.assertTrue(new ProjectsViewerPage().isProfileIconDisplayed(), "Error while Logging in");
    }

    @Test
    public void loginWithInvalidCredentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage().get();
        loginPage.enterUsername(Infos.USERNAME);
        loginPage.enterPassword(Infos.PASSWORD);
        loginPage.clickLogInButton();

        Thread.sleep(2000);
        Assert.assertTrue(loginPage.initPage().isErrorAlertDisplayed(), "Error alert is not displayed");
    }
}
