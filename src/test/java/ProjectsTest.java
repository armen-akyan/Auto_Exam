import Helpers.Infos;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.DriverSetUp;

public class ProjectsTest {

    @BeforeMethod
    public void drive() throws InterruptedException {
        DriverSetUp.get().getDriver().manage().window().maximize();
        LoginTest.loginWithValidCredentials();
    }

    @AfterMethod
    public void endDrive() {
        DriverSetUp.quit();
    }

    @Test
    public void createScrumProject() {
        ProjectsViewerPage projectsViewerPage = new ProjectsViewerPage();
        ScrumPage scrumPage = projectsViewerPage.clickNewProjectButton().initPage().clickScrumProjectButton();
        scrumPage.initPage().setProjectNameField(Infos.GENERATED_NAME);
        scrumPage.setProjectDescriptionField(Infos.GENERATED_NAME + "___Description");
        ProjectPage projectPage = scrumPage.clickCreateProjectButton();
        Assert.assertTrue(projectPage.initPage().isScrumTextH1Displayed(), "Error while creating a Scrum project");
    }
}
