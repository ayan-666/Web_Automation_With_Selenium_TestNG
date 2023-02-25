package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class PIMPage {
    @FindBy(tagName = "h5")
    public WebElement pimTitle;
    @FindBy(className = "oxd-text--h6")
    public List<WebElement> addTitle;
    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']")
    public WebElement pimButton;
    @FindBy(className = "oxd-button--medium")
    public List<WebElement> addButton;
    @FindBy(xpath = "//h6[normalize-space()='Personal Details']")
    public WebElement afterAddTitle;
    @FindBy(name = "firstName")
    WebElement first_name;
    @FindBy(name = "lastName")
    WebElement last_name;
    @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    public WebElement empId;
    @FindBy(xpath = "//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")
    WebElement btn_toggle;
    @FindBy(className = "oxd-input--active")
    List<WebElement> login_info;
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement password_field;
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement confirm_pass;
    @FindBy(css = "[type=submit]")
    WebElement save_button;
    @FindBy(tagName = "input")
    public List<WebElement> name;
    @FindBy(tagName = "button")
    public List<WebElement> searchButton;
    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span']")
    public WebElement title;
    @FindBy(xpath = "//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']")
    public WebElement userClick;
    //@FindBy(className = "oxd-input--active")
    @FindBy(tagName = "input")
    public List<WebElement> id;
    @FindBy(className = "oxd-button--secondary")
    public List<WebElement> saveButton;
    @FindBy(className = "oxd-input--active")
    public List<WebElement> idField;
    @FindBy(className = "oxd-userdropdown-tab")
    public WebElement logoutDropdown;
    @FindBy(className = "oxd-userdropdown-link")
    public List<WebElement> logoutclick;
    public PIMPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void PIMButton(){
        pimButton.click();
    }
    public void AddButton(){
        addButton.get(2).click();
    }
    public void createEmployee(String firstname,String lastname,String username,String password) throws InterruptedException {
        first_name.sendKeys(firstname);
        last_name.sendKeys(lastname);
        Thread.sleep(1000);
        btn_toggle.click();
        Thread.sleep(1000);
        login_info.get(5).sendKeys(username);
        password_field.sendKeys(password);
        confirm_pass.sendKeys(password);
        Thread.sleep(2000);
        save_button.click();
        Thread.sleep(1000);
    }

}
