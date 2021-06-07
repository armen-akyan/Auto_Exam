import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.DriverSetUp;

public class ProjectsViewerPage extends BasePage<ProjectsViewerPage> {

    @FindBy(css = "[tg-nav='profile']")
    private WebElement profileIcon;

    @FindBy(css = "[title='Create project']")
    private WebElement newProjectButton;

    @Override
    public String getUrl() {
        return BASE_URL;
    }

    public ProjectsViewerPage() {
        open();
        PageFactory.initElements(DriverSetUp.getDriver(), this);
    }

    public boolean isProfileIconDisplayed() {
        return isDisplayed(profileIcon);
    }

    public CreateProjectPage clickNewProjectButton() {
        click(newProjectButton);
        return new CreateProjectPage();
    }
}
