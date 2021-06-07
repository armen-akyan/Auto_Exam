import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateProjectPage extends BasePage<CreateProjectPage> {

    @FindBy(css="[tg-nav='create-project-scrum']")
    private WebElement scrumProjectButton;

    @Override
    public String getUrl() {
        return BASE_URL + "project/new";
    }

    public ScrumPage clickScrumProjectButton(){

        click(scrumProjectButton);
        return new ScrumPage();
    }
}
