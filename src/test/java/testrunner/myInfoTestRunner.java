package testrunner;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.setup;
import utils.utils;
import pages.loginPage;
import pages.myInfoPage;
import pages.PIMPage;
import java.io.IOException;

public class myInfoTestRunner extends setup {
    public loginPage loginPage;
    public myInfoPage myInfoPage;
    public PIMPage PIMPage;
    @Test(priority = 1,description = "Second Employee Login")
    public void secondUserLogin() throws IOException, ParseException, InterruptedException {
        loginPage = new loginPage(driver);
        String username= utils.readUserName(1);
        String password=utils.readPassword(1);
        Thread.sleep(2000);
        loginPage.doLogin(username,password);
        String actual_title = loginPage.dashboardTitle.getText();
        String expected_title = "Dashboard";
        Assert.assertTrue(actual_title.contains(expected_title));
        Thread.sleep(2000);
    }
    @Test(priority = 2,description = "Click My Info From Menu")
    public void myInfoClick() throws InterruptedException {
        myInfoPage =new myInfoPage(driver);
        myInfoPage.myInfoClick();
        Thread.sleep(3000);
        String expected_title="Personal Details";
        PIMPage = new PIMPage(driver);
        String actual_title=PIMPage.afterAddTitle.getText();
        Assert.assertTrue(actual_title.contains(expected_title));
        utils.doScroll(driver,600);
        Thread.sleep(2000);
    }
    @Test(priority = 3,description = "Select Gender")
    public void selectGender() throws InterruptedException {
        myInfoPage =new myInfoPage(driver);
        Assert.assertTrue(myInfoPage.radioButton.get(0).isDisplayed());
        myInfoPage.radioButton.get(0).click();
        myInfoPage.saveButton.get(0).click();
        Thread.sleep(2000);
    }
    @Test(priority = 4,description = "Select Blood Type")
    public void selectBloodType() throws InterruptedException {
        WebElement dropdownElement=myInfoPage.dropdown.get(2);
        Actions act=new Actions(driver);
        act.moveToElement(dropdownElement);
        dropdownElement.click();
        Assert.assertTrue(myInfoPage.radioButton.get(0).isDisplayed());
        act.keyDown(Keys.ARROW_DOWN).perform();
        act.keyDown(Keys.ARROW_DOWN).perform();
        act.keyDown(Keys.ARROW_DOWN).perform();
        act.keyDown(Keys.RETURN).perform();
        myInfoPage.saveButton.get(1).click();
        Thread.sleep(2000);
        utils.doScroll(driver,-600);
    }
    @Test(priority = 5,description ="Click Contact And Give Adress & Email")
    public void contact() throws InterruptedException {
        myInfoPage.contact.get(1).click();
        String actual_titile= myInfoPage.contactTitile.get(2).getText();
        String expected_titile="Contact Details";
        Assert.assertTrue(actual_titile.contains(expected_titile));
        Thread.sleep(2000);
        myInfoPage.adressEmail.get(1).sendKeys(Keys.COMMAND+"a",Keys.DELETE);
        myInfoPage.adressEmail.get(1).sendKeys("Dhaka");
        Thread.sleep(1000);
        myInfoPage.adressEmail.get(9).sendKeys(Keys.COMMAND+"a",Keys.DELETE);
        myInfoPage.adressEmail.get(9).sendKeys("admin@gamil.com");
        Thread.sleep(1000);
        myInfoPage.contactBtn.click();
        Thread.sleep(3000);
    }
    @Test(priority = 6,description = "logout")
    public void logoutSecondUser() throws InterruptedException {
        PIMPage=new PIMPage(driver);
        PIMPage.logoutDropdown.click();
        Thread.sleep(2000);
        PIMPage.logoutclick.get(3).click();
        Thread.sleep(2000);
        String expected_title="Login";
        String actual_title=loginPage.loginPageTitle.getText();
        Assert.assertTrue(actual_title.contains(expected_title));
        Thread.sleep(2000);
    }
}
