import Helpers.Infos;
import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.DriverSetUp;

import java.net.MalformedURLException;

public class ProjectsViewerPage extends BasePage<ProjectsViewerPage> {

    @FindBy(css = "[tg-nav='profile']")
    private WebElement profileIcon;

    @FindBy(css = "[title='Create project']")
    private WebElement newProjectButton;

    @Override
    public String getUrl() {
        return Infos.BASE_URL;
    }

    public ProjectsViewerPage() throws MalformedURLException {
        open();
        PageFactory.initElements(DriverSetUp.get().getDriver(), this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }

    public boolean isProfileIconDisplayed() {
        return isDisplayed(profileIcon);
    }

    public CreateProjectPage clickNewProjectButton() {
        click(newProjectButton);
        return new CreateProjectPage();
    }
}
