package stepDefinitions;
import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import util.DriverFactory;

public class LoginPageStepDefinitions {
    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("User at home page")
    public void userAtHomePage() {
        loginPage.userAtHomePage();
    }

    @When("Click login button")
    public void clickLoginButton() {
        loginPage.clickLogin();
    }

    @Then("Check {string} massage about username")
    public void checkMassageAboutUsername(String username) {
        loginPage.checkMessage(username);

    }

    @When("Write {string} for username field")
    public void writeForUsernameField(String Username) {
        loginPage.writeUsernameForUsernameField(Username);
    }

    @Then("Check {string} massage about password")
    public void checkMassageAboutPassword(String error) {
        loginPage.checkMessage(error);
    }

    @When("Write {string} for password field")
    public void writeForPasswordField(String password) {
        loginPage.writePasswordForPasswordField(password);
    }

    @When("Write Correct {string} for username field")
    public void writeCorrectForUsernameField(String correctUsername) {
        loginPage.correctUsernameForUsernameField(correctUsername);
    }

    @When("Write False {string} for password field")
    public void writeFalseForPasswordField(String falsePassword) {
        loginPage.falsePasswordForPasswordField(falsePassword);
    }

    @Then("Check {string} message about don't match")
    public void checkMessageAboutDonTMatch(String dontMatch) {
        loginPage.dontMatchErrorMassage(dontMatch);
    }

    @When("Write False {string} for username field")
    public void writeFalseForUsernameField(String falseUsername) {
        loginPage.writeFalseUsername(falseUsername);
    }

    @When("Write Correct {string} for password field")
    public void writeCorrectForPasswordField(String correctPassword) {
        loginPage.writeCorrectPassword(correctPassword);
    }

    @Then("Check Successful login")
    public void checkSuccessfulLogin() {
        loginPage.checkSuccessfulLogin();
    }
}
