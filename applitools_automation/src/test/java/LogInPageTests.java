import org.junit.jupiter.api.Test;
import pages.DashboardPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class LogInPageTests extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        driver.get("https://demo.applitools.com/");

        // Maximize the browser window to ensure the username is displayed
        // and can be checked against the assertion.
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Fabián");
        loginPage.enterPassword("password");
        DashboardPage dashboard = loginPage.clickLogInButton();

        assertEquals("Jack Gomez", dashboard.getUsernameTitle());
        assertEquals("Total Balance", dashboard.getBalanceTitle());
        assertEquals("Credit Available", dashboard.getCreditTitle());
        assertEquals("Recent Transactions", dashboard.getRecentTransactionsTitle());
    }
}
