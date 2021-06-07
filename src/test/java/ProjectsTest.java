import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.DriverSetUp;

import java.util.UUID;

public class ProjectsTest {

    @BeforeMethod
    public void drive() throws InterruptedException {
        DriverSetUp.getDriver().manage().window().maximize();
        LoginTest.loginWithValidCredentials();
    }

    @AfterMethod
    public void endDrive() {
        DriverSetUp.quit();
    }

    @Test
    public void createScrumProject() {
        ProjectsViewerPage projectsViewerPage = new ProjectsViewerPage();
        ScrumPage scrumPage = projectsViewerPage.clickNewProjectButton().clickScrumProjectButton();
        scrumPage.setProjectNameField(BasePage.GENERATED_NAME);
        scrumPage.setProjectDescriptionField(BasePage.GENERATED_NAME + "___Description");
        ProjectPage projectPage = scrumPage.clickCreateProjectButton();
        Assert.assertTrue(projectPage.isScrumTextH1Displayed(), "Error while creating a Scrum project");

    }
}
