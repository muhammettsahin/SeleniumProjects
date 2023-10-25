package Pages;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import static org.testng.AssertJUnit.assertEquals;


public class LoginPage {
    WebDriver driver;
    util.ElementHelper elementHelper;
    WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
        this.elementHelper = new ElementHelper(driver);}

    By LoginTitle = By.cssSelector(".oxd-text.oxd-text--h5.orangehrm-login-title");
    By LoginButton = By.cssSelector("button[type='submit']");
    By requiredMessageforUsername = By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > form:nth-child(2) > div:nth-child(2) > div:nth-child(1) > span:nth-child(3)");
    By getRequiredMessageforPassword = By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > form:nth-child(2) > div:nth-child(3) > div:nth-child(1) > span:nth-child(3)");
    By usernamefield = By.cssSelector("input[placeholder='Username']");
    By passwordfield = By.cssSelector("input[placeholder='Password']");
    By InvalidCredentialsMassage = By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text");
    By Dashboard = By.cssSelector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");

    public void verifyUserAtLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement title = driver.findElement(LoginTitle);
        String titleText = title.getText();
        assertEquals(titleText,"Login");
    }

    public void clickLoginButton() {
        driver.findElement(LoginButton).click();
    }

    public void checkRequiredMessage() {
        elementHelper.checkVisible(requiredMessageforUsername);
        elementHelper.checkVisible(getRequiredMessageforPassword);
    }

    public void writeUsernameAndPassword() {
        driver.findElement(usernamefield).click();
        elementHelper.sendKey(usernamefield,"abcdefg");
        driver.findElement(passwordfield).click();
        elementHelper.sendKey(passwordfield,"123456");
    }

    public void checkInvalidCredentialsMessage() {
        WebElement errorMessage = driver.findElement(InvalidCredentialsMassage);
        String errorMassageText = errorMessage.getText();
        assertEquals(errorMassageText,"Invalid credentials");
    }

    public void writeCorrectUsernameAndPassword() {
        driver.findElement(usernamefield).click();
        elementHelper.sendKey(usernamefield,"admin");
        driver.findElement(passwordfield).click();
        elementHelper.sendKey(passwordfield,"admin123");
    }

    public void checkDashboard() {
        WebElement DashboardElement = driver.findElement(Dashboard);
        String DashboardElementText = DashboardElement.getText();
        assertEquals(DashboardElementText,"Dashboard");
    }
}
