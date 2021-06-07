import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ScrumPage extends BasePage<ScrumPage> {


    @FindBy(css = "[placeholder='Project Name (Required)']")
    private WebElement projectNameField;

    @FindBy(css = "[placeholder='Project Description (Required)']")
    private WebElement projectDescriptionField;


    @FindBy(css = ".create-project-action-submit")
    private WebElement createProjectButton;


    @Override
    public String getUrl() {
        return BASE_URL + "/project/new/scrum";
    }

    public void setProjectNameField(String text) {
        type(projectNameField, text);
    }

    public void setProjectDescriptionField(String text) {
        type(projectDescriptionField, text);
    }

    public ProjectPage clickCreateProjectButton() {
        click(createProjectButton);
        return new ProjectPage();
    }

}
