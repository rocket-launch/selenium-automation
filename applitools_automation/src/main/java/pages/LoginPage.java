package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    // Text fields
    private final By userNameLocator = By.cssSelector("#username.form-control");
    private final By passwordLocator = By.cssSelector("#password.form-control");

    // Buttons
    private final By logInButtonLocator = By.cssSelector("#log-in.btn");

    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        WebElement userNameTextField = driver.findElement(userNameLocator);
        userNameTextField.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordTextField = driver.findElement(passwordLocator);
        passwordTextField.sendKeys(password);
    }

    public DashboardPage clickLogInButton() {
        WebElement loginButton = driver.findElement(logInButtonLocator);
        loginButton.click();
        return new DashboardPage(driver);
    }
}
