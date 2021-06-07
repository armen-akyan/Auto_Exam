import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectPage extends BasePage<ProjectPage> {


    @FindBy(css = "[i18n-section-name='Scrum']")
    private WebElement scrumTextH1;

    @Override
    public String getUrl() {
        return BASE_URL + "/project/" + USERNAME + "-" + GENERATED_NAME + "/backlog";
    }

    public boolean isScrumTextH1Displayed() {
        return isDisplayed(scrumTextH1);
    }

}
