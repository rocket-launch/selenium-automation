package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class DashboardPage {

    private WebDriver driver;
    private By totalBalanceTitleLocator = By.cssSelector(".element-balances .balance-title");
    private By totalCreditTitleLocator = By.cssSelector(".element-balances .balance:nth-child(2) .balance-title");
    private By recentTransactionsTitleLocator = By.cssSelector(".content-box > div:nth-child(2) h6");
    private By usernameTitleLocator = By.cssSelector(".logged-user-name");
    private By transactionsTable = By.cssSelector(".table-responsive tbody tr");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getBalanceTitle() {
        return driver.findElement(totalBalanceTitleLocator).getText();
    }

    public String getCreditTitle() {
        return driver.findElement(totalCreditTitleLocator).getText();
    }

    public String getRecentTransactionsTitle() {
        return driver.findElement(recentTransactionsTitleLocator).getText();
    }

    public String getUsernameTitle() {
        return driver.findElement(usernameTitleLocator).getText();
    }
    public Hashtable<String, String> getTransactionsList() {
        List<WebElement> transactions = driver.findElements(transactionsTable);
        Hashtable<String, String> recentTransactionDictionary = new Hashtable<>();

        for (WebElement transaction: transactions) {
            WebElement status = transaction.findElement(By.cssSelector("tr td:first-child span:last-child"));
            WebElement description = transaction.findElement(By.cssSelector("tr td:nth-child(3) span"));
            recentTransactionDictionary.put(description.getText(), status.getText());
        }

        return recentTransactionDictionary;
    }
}
