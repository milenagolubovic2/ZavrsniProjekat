import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1_GoogleSearchTest {

    // Test case 1: Open Google search, find and open Gigatron site

    @Test
    public void openBrowser() throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Creating object of Google Home page
        GoogleHomePage googleHome = new GoogleHomePage(driver);

        //Creating object of Gigatron Home page
        GigatronHomePage gigatronHome = new GigatronHomePage(driver);

        // Launch Google.rs page
        googleHome.openGoogleURL();
        Thread.sleep(5000);

        // Perform a search using "Gigatron"
        googleHome.enterGoogleSearch("Gigatron");
        Thread.sleep(1000);
        googleHome.clickGoogleSearch();
        Thread.sleep(3000);

        // Find and open Gigatron web page from search results, verify Gigatron page title
        googleHome.clickSearchResult();
        Thread.sleep(3000);
        boolean isSiteTitleVisible = gigatronHome.siteTitleVisible();
        Assert.assertEquals(isSiteTitleVisible, true);
        Thread.sleep(3000);

        // Accept cookies on Gigatron site
        gigatronHome.clickAcceptCookies();
        Thread.sleep(3000);

        System.out.println("TEST PASSED: Gigatron site successfully found and opened from Google search.");

        driver.quit();
    }
}
