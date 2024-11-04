package applitools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LogInThenPrintBalanceAndTransactions {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.applitools.com/");
        //Account sign in.
        WebElement usernameField = driver.findElement(By.cssSelector("#username.form-control"));
        usernameField.sendKeys("admin");
        WebElement passwordField = driver.findElement(By.cssSelector("#password.form-control"));
        passwordField.sendKeys("admin");
        WebElement signInButton = driver.findElement(By.cssSelector("#log-in.btn"));
        signInButton.click();

        //Print balance and transactions.
        WebElement totalBalanceTitle = driver.findElement(By.cssSelector(".element-balances .balance-title"));
        WebElement totalBalance = driver.findElement(By.cssSelector(".balance-value span:first-child"));
        WebElement totalCreditTitle = driver.findElement(By.cssSelector(".element-balances .balance:nth-child(2) .balance-title"));
        WebElement totalCredit = driver.findElement(By.cssSelector(".element-balances .balance:nth-child(2) .balance-value"));

        System.out.println(totalBalanceTitle.getText());
        System.out.println("=".repeat(20));
        System.out.println(totalBalance.getText() + "\n");

        System.out.println(totalCreditTitle.getText());
        System.out.println("=".repeat(20));
        System.out.println(totalCredit.getText() + "\n");

        System.out.println("Transactions");
        System.out.println("=".repeat(20));
        List<WebElement> transactions = driver.findElements(By.cssSelector(".table-responsive tbody tr"));
        for (WebElement transaction: transactions) {
            WebElement status = transaction.findElement(By.cssSelector("tr td:first-child span:last-child"));
            WebElement description = transaction.findElement(By.cssSelector("tr td:nth-child(3) span"));
            WebElement amount = transaction.findElement(By.cssSelector("tr td:nth-child(5) span"));
            System.out.println("| " + description.getText() + " | " + amount.getText() + " | " + status.getText() + " |");
        }

        driver.quit();
    }
}
