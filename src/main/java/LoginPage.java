import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.DriverSetUp;
import Helpers.Infos;

public class LoginPage extends BasePage<LoginPage> {

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(css = "[title='Login']")
    private WebElement logInButton;


    @FindBy(css = "[class='notification-light notification-message-light-error active']")
    private WebElement errorAlert;

    @Override
    public String getUrl() {
        return Infos.BASE_URL + "login";
    }

    public LoginPage() {
        open();
        PageFactory.initElements(DriverSetUp.getDriver(), this);
    }

    public void enterUsername(String username) {
        if (isDisplayed(usernameField))
            type(usernameField, username);
    }

    public void enterPassword(String password) {
        if (isDisplayed(passwordField))
            type(passwordField, password);
    }

    public void clickLogInButton() {
        click(logInButton);
    }

    public boolean isErrorAlertDisplayed() {
        return isDisplayed(errorAlert);
    }
}
