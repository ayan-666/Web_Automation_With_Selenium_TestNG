package testrunner;
import com.github.javafaker.Faker;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.PIMPage;
import pages.loginPage;
import setup.setup;
import utils.utils;
import java.io.IOException;

public class pimPageTestRunner extends setup{
    public PIMPage PIMPage;
    public loginPage loginPage;

    @BeforeTest
    public void doLogin() throws InterruptedException {
        loginPage = new loginPage(driver);
        String username="Admin";
        String password="admin123";
        Thread.sleep(1000);
        loginPage.doLogin(username,password);
        Thread.sleep(2000);
    }

    @Test(priority = 1,description = "Click PIM And Assert PIM Page Title")
    public void assertPimPageTitle() throws InterruptedException {
        PIMPage =new PIMPage(driver);
        PIMPage.PIMButton();
        String expected_title="Employee Information";
        String actual_title=PIMPage.pimTitle.getText();
        Assert.assertTrue(actual_title.contains(expected_title));
        Thread.sleep(2000);
    }
    @Test(priority = 2,description = "Click Add Button On PIM Page")
    public void clickAddOnPIMPage() throws InterruptedException {
        PIMPage=new PIMPage(driver);
        PIMPage.AddButton();
        String actual_title=PIMPage.addTitle.get(1).getText();
        String expected_title="Add Employee";
        Assert.assertTrue(actual_title.contains(expected_title));
        Thread.sleep(2000);
    }

    @Test(priority = 3, description = "Create First Employee")
    public void addFirstEmployee() throws InterruptedException, IOException, ParseException {
        PIMPage=new PIMPage(driver);
        Faker faker=new Faker();
        String firstname=faker.name().firstName();
        String lastname=faker.name().lastName();
        String emp_id= PIMPage.empId.getAttribute("value");
        String username="Roy"+ utils.generateRandomNumber(1000, 9999);
        String password="P@ssword123";
        PIMPage.createEmployee(firstname,lastname,username,password);
        utils.addJsonArray(firstname,lastname,emp_id,username,password);
        String expected_title="Personal Details";
        String actual_title=PIMPage.afterAddTitle.getText();
        Assert.assertTrue(actual_title.contains(expected_title));
        Thread.sleep(2000);
    }
    @Test(priority = 4,description = "Create Second Employee")
    public void addSecondEmployee() throws InterruptedException, IOException, ParseException {
        PIMPage=new PIMPage(driver);
        PIMPage.PIMButton();
        PIMPage.AddButton();
        Faker faker=new Faker();
        String firstname=faker.name().firstName();
        String lastname=faker.name().lastName();
        String emp_id= PIMPage.empId.getAttribute("value");
        String username="Roy"+ utils.generateRandomNumber(1000, 9999);
        String password="P@ssword123";
        PIMPage.createEmployee(firstname,lastname,username,password);
        utils.addJsonArray(firstname,lastname,emp_id,username,password);
        String expected_title="Personal Details";
        String actual_title=PIMPage.afterAddTitle.getText();
        Assert.assertTrue(actual_title.contains(expected_title));
        Thread.sleep(1000);
    }
    @Test(priority = 5,description = "Search First Employee By Name")
    public void searchFirstEmployeeByName() throws IOException, ParseException, InterruptedException {
        PIMPage=new PIMPage(driver);
        PIMPage.PIMButton();
        String name=utils.readJSONArray(0);
        PIMPage.name.get(1).sendKeys(name);
        Thread.sleep(1000);
        PIMPage.searchButton.get(3).click();
        String expected_title="Record Found";
        String actual_title=PIMPage.title.getText();
        Thread.sleep(2000);
        Assert.assertTrue(actual_title.contains(expected_title));
        utils.doScroll(driver, 100);
        Thread.sleep(1000);

    }
    @Test(priority = 6,description = "First Employee Click After Search By Name")
    public void firstEmployeeClick() throws InterruptedException {
        PIMPage.userClick.click();
        Thread.sleep(1000);
        String expected_title="Personal Details";
        String actual_title=PIMPage.afterAddTitle.getText();
        Assert.assertTrue(actual_title.contains(expected_title));
        Thread.sleep(3000);
    }
    @Test(priority = 7,description = "Update First Employee Id By Randomly")
    public void updateFirstEmployeeId() throws InterruptedException, IOException, ParseException {
        String updated_id="0"+utils.generateRandomNumber(1000,9000);
        PIMPage.id.get(5).sendKeys(Keys.COMMAND+"a",Keys.DELETE);//Input field clear
        PIMPage.id.get(5).sendKeys(updated_id);
        Thread.sleep(1000);
        PIMPage.saveButton.get(0).click();
        utils.updateJSONList(0,"empId",updated_id);
    }
    @Test(priority = 8,description = "Again Search First Employee With Updated Id")
    public void searchFirstEmployeeWithUpdatedId() throws IOException, ParseException, InterruptedException {
        PIMPage =new PIMPage(driver);
        PIMPage.PIMButton();
        Thread.sleep(1000);
        PIMPage.idField.get(1).sendKeys(utils.readJSONArray1(0));
        Thread.sleep(1000);
        PIMPage.searchButton.get(3).click();
        String expected_title="Record Found";
        String actual_title=PIMPage.title.getText();
        Thread.sleep(2000);
        Assert.assertTrue(actual_title.contains(expected_title));
        utils.doScroll(driver, 100);
        Thread.sleep(2000);
    }
    @Test(priority = 9,description = "Logout From Admin")
    public void adminLogout() throws InterruptedException {
        PIMPage.logoutDropdown.click();
        Thread.sleep(1000);
        PIMPage.logoutclick.get(3).click();
        Thread.sleep(2000);
        String expected_title="Login";
        String actual_title=loginPage.loginPageTitle.getText();
        Assert.assertTrue(actual_title.contains(expected_title));
        Thread.sleep(2000);
    }
}
