package testrunner;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.setup;
import pages.loginPage;
import java.io.IOException;

public class loginPageTestRunner extends setup {
    public loginPage loginPage;

    @Test(priority = 1,description = "Admin Login With Invalid Password")
    public void doLoginWithInvalidPassword() throws InterruptedException {
        loginPage = new loginPage(driver);
        String username="Admin";
        String password="admin1234";
        Thread.sleep(1000);
        loginPage.doLogin(username,password);
        Thread.sleep(2000);
        String expected_title="Invalid credentials";
        String actual_title=loginPage.validationTitle.getText();
        Assert.assertTrue(actual_title.contains(expected_title));
        Thread.sleep(1000);
    }

    @Test(priority = 2,description = "Admin Login With Invalid Username")
    public void doLoginWithInvalidUsername() throws InterruptedException {
        loginPage = new loginPage(driver);
        String username="Admin1";
        String password="admin123";
        Thread.sleep(1000);
        loginPage.doLogin(username,password);
        Thread.sleep(2000);
        String expected_title="Invalid credentials";
        String actual_title=loginPage.validationTitle.getText();
        Assert.assertTrue(actual_title.contains(expected_title));
        Thread.sleep(1000);
    }

    @Test(priority = 3,description = "Admin Login Without Providing any credentials")
    public void doLoginWithoutAnyCredentials() throws InterruptedException {
        loginPage = new loginPage(driver);
        String username="";
        String password="";
        Thread.sleep(1000);
        loginPage.doLogin(username,password);
        Thread.sleep(2000);
        String expected_title="Invalid credentials";
        String actual_title=loginPage.validationTitle.getText();
        Assert.assertTrue(actual_title.contains(expected_title));
        Thread.sleep(1000);
    }

    @Test(priority = 4,description = "Admin Login With Valid Credentials")
    public void doLoginWithValidCreds() throws InterruptedException, IOException, ParseException {
        loginPage = new loginPage(driver);
        String username="Admin";
        String password="admin123";
        Thread.sleep(1000);
        loginPage.doLogin(username,password);
        Thread.sleep(2000);
        String actual_title = loginPage.dashboardTitle.getText();
        String expected_title = "Dashboard";
        Assert.assertTrue(actual_title.contains(expected_title));
        Thread.sleep(2000);
    }
}
