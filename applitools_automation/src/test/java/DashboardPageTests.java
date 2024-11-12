import org.junit.jupiter.api.Test;
import pages.DashboardPage;
import pages.LoginPage;

import java.util.Hashtable;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class DashboardPageTests extends  BaseTest {
    @Test
    public void testTransactionListLoadedSuccessfully() {
        driver.get("https://demo.applitools.com/");

        // Log in.
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Fabián");
        loginPage.enterPassword("password");
        DashboardPage dashboard = loginPage.clickLogInButton();

        // Check the number of recent transactions loaded.
        var transactionsList = dashboard.getTransactionsList();
        assertEquals(6, transactionsList.size());

        // Gets list of keys and stores them in a set.
        // This assumes that each company in the transactions' list is unique by showing only its latest transaction.
        Set<String> companyKeys = transactionsList.keySet();

        for(String key : companyKeys) {
            // Check if the retrieved company's name is one of the registered companies.
            assertTrue(key.matches("Stripe Payment Processing|MailChimp Services|Starbucks coffee|Templates Inc|Shopify product|Ebay Marketplace"));

            // Check if the retrieved transaction status is a valid status.
            assertTrue(transactionsList.get(key).matches("Pending|Declined|Complete"));
        }
    }
}
