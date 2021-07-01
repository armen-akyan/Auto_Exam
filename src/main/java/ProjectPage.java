import Helpers.Infos;
import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectPage extends BasePage<ProjectPage> {


    @FindBy(css = "[i18n-section-name='Scrum']")
    private WebElement scrumTextH1;

    @Override
    public String getUrl() {
        return Infos.BASE_URL + "/project/" + Infos.USERNAME + "-" + Infos.GENERATED_NAME + "/backlog";
    }

    public boolean isScrumTextH1Displayed() {
        return isDisplayed(scrumTextH1);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }
}
