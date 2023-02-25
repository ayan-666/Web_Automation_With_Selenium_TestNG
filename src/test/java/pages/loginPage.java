package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
    @FindBy(name="username")
    WebElement txtUserName;
    @FindBy(name="password")
    WebElement txtPassword;
    @FindBy(css="[type=submit]")
    WebElement btnSubmit;
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    public WebElement validationTitle;
    @FindBy(xpath = "//h5[normalize-space()='Login']")
    public WebElement loginPageTitle;
    @FindBy(tagName = "h6")
    public WebElement dashboardTitle;

    public loginPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    public void doLogin(String username, String password){
        txtUserName.sendKeys(username);
        txtPassword.sendKeys(password);
        btnSubmit.click();
    }
}
