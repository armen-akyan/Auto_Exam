import Helpers.Infos;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.DriverSetUp;

import java.net.MalformedURLException;

public class ProjectsTest {

    @BeforeMethod
    public void drive() throws InterruptedException, MalformedURLException {
        DriverSetUp.get().getDriver().manage().window().maximize();
        LoginTest.loginWithValidCredentials();
    }

    @AfterMethod
    public void endDrive() {
        DriverSetUp.get().quit();
    }

    @Test
    @Description("Test Case Description: Verify Create Scrum project functionality")
    public void createScrumProject() throws MalformedURLException {
        ProjectsViewerPage projectsViewerPage = new ProjectsViewerPage();
        ScrumPage scrumPage = projectsViewerPage.clickNewProjectButton().initPage().clickScrumProjectButton();
        scrumPage.initPage().setProjectNameField(Infos.GENERATED_NAME);
        scrumPage.setProjectDescriptionField(Infos.GENERATED_NAME + "___Description");
        ProjectPage projectPage = scrumPage.clickCreateProjectButton();
        Assert.assertTrue(projectPage.initPage().isScrumTextH1Displayed(), "Error while creating a Scrum project");
    }
}
