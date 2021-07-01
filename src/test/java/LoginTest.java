import Helpers.ApiHelper;
import Helpers.Infos;
import com.google.gson.JsonObject;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import setup.DriverSetUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

@Listeners(TestAllureListener.class)
public class LoginTest {
    @BeforeMethod
    public void drive() {
        DriverSetUp.get().getDriver();
    }

    @AfterMethod
    public void endDrive() throws IOException, InterruptedException {
        DriverSetUp.get().quit();
    }

    @Test
    @Description("Test Case Description: Verify login functionality with API login")
    public static void loginWithAPI() throws IOException {
        JsonObject jsonObject = ApiHelper.login();
        Assert.assertEquals(jsonObject.get("full_name").toString(), "\"Armen Armenakyan\"", "Login failed");
    }

    @Test
    @Description("Test Case Description: Verify login functionality with valid credentials")
    public static void loginWithValidCredentials() throws InterruptedException, MalformedURLException {
        LoginPage loginPage = new LoginPage().get();
        loginPage.enterUsername(Infos.USERNAME);
        loginPage.enterPassword(Infos.PASSWORD);
        loginPage.clickLogInButton();

        Thread.sleep(2000);
        Assert.assertTrue(new ProjectsViewerPage().isProfileIconDisplayed(), "Error while Logging in");
    }

    @Test
    @Description("Test Case Description: Verify login functionality with invalid credentials")
    public void loginWithInvalidCredentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage().get();
        loginPage.enterUsername(Infos.USERNAME);
        loginPage.enterPassword(Infos.PASSWORD);
        loginPage.clickLogInButton();

        Thread.sleep(2000);
        Assert.assertTrue(loginPage.initPage().isErrorAlertDisplayed(), "Error alert is not displayed");
    }
}
