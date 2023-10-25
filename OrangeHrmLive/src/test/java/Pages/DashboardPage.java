package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import static org.testng.AssertJUnit.assertEquals;

public class DashboardPage {
    WebDriver driver;
    util.ElementHelper elementHelper;
    WebDriverWait wait;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
        this.elementHelper = new ElementHelper(driver);}

    By MyInfo = By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > aside:nth-child(1) > nav:nth-child(1) > div:nth-child(2) > ul:nth-child(2) > li:nth-child(6) > a:nth-child(1) > span:nth-child(2)");
    By SaveButton = By.cssSelector("div[class='orangehrm-horizontal-padding orangehrm-vertical-padding'] button[type='submit']");
    By NameAndSurnameTitle = By.cssSelector(".oxd-userdropdown-name");
    public void clickToMyInfo() {
        driver.findElement(MyInfo).click();
    }

    public void changeNameAndSurname() {
        WebElement Username = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > div > div.orangehrm-edit-employee-content > div.orangehrm-horizontal-padding.orangehrm-vertical-padding > form > div:nth-child(1) > div.oxd-grid-1.orangehrm-full-width-grid > div > div > div.--name-grouped-field > div:nth-child(1) > div:nth-child(2) > input"));
        Username.sendKeys(Keys.CONTROL+"a");
        Username.sendKeys(Keys.DELETE);
        Username.sendKeys("Muhammet");

        WebElement Surname = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > div > div.orangehrm-edit-employee-content > div.orangehrm-horizontal-padding.orangehrm-vertical-padding > form > div:nth-child(1) > div.oxd-grid-1.orangehrm-full-width-grid > div > div > div.--name-grouped-field > div:nth-child(3) > div:nth-child(2) > input"));
        Surname.sendKeys(Keys.CONTROL+"a");
        Surname.sendKeys(Keys.DELETE);
        Surname.sendKeys("Şahin");

    }

    public void clickToSaveButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)");
        driver.findElement(SaveButton).click();
    }

    public void checkNewNameAndSurname() {
        driver.findElement(MyInfo).click();
        WebElement NewNameAndSurname = driver.findElement(NameAndSurnameTitle);
        String NewNameAndSurnameText = NewNameAndSurname.getText();
        assertEquals(NewNameAndSurnameText,"Muhammet Şahin");
        
    }
}
