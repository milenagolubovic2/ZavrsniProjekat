import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC2_LoginFormTest {

    // Test case 2 : Open Gigatron Login form and enter valid data

    @Test
    public void openBrowser() throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Creating object of Gigatron Home page
        GigatronHomePage gigatronHome = new GigatronHomePage(driver);

        //Creating object of Gigatron Login page
        GigatronLoginPage gigatronLogin = new GigatronLoginPage(driver);

        // Launch Gigatron page
        gigatronHome.openGigatronURL();
        Thread.sleep(5000);

        // Accept cookies on Gigatron site
        gigatronHome.clickAcceptCookies();
        Thread.sleep(3000);

        // Open Login form
        gigatronLogin.clickLoginForm();
        Thread.sleep(3000);

        // Type valid data for username and password
        gigatronLogin.enterEmail("milenagolubovic2@gmail.com");
        Thread.sleep(1500);
        gigatronLogin.enterPassword("Gigatron2021.");
        Thread.sleep(1500);

        // Click on Login button
        gigatronLogin.clickLogin();

        // Wait for page to be loaded  and verify that User is Successfully login on his account
        gigatronLogin.checkUserLoginSuccess();
        Thread.sleep(3000);

        driver.quit();
    }
}
