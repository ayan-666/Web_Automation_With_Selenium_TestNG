package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class myInfoPage {

    @FindBy(xpath = "//span[normalize-space()='My Info']")
    WebElement myInfoButton;
    @FindBy(className= "oxd-radio-wrapper")
    public List<WebElement> radioButton;
    @FindBy(className = "oxd-button")
    public List<WebElement> saveButton;
    @FindBy(className = "oxd-select-wrapper")
    public List<WebElement> dropdown;
    @FindBy(className = "orangehrm-tabs-item")
    public List<WebElement> contact;
    @FindBy(className = "oxd-text--h6")
    public List<WebElement> contactTitile;
    @FindBy(className = "oxd-input")
    public List<WebElement> adressEmail;
    @FindBy(xpath = "//button[normalize-space()='Save']")
    public WebElement contactBtn;

    public myInfoPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }
    public void myInfoClick(){
        myInfoButton.click();
    }

}
