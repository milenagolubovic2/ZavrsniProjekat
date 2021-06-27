import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC4_CheckSocialNetworkWidgetsTest {

    // Test4 : Check Social network widgets are visible on Gigatron page

    @Test
    public void openBrowser() throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Creating object of Gigatron Home page
        GigatronHomePage gigatronHome = new GigatronHomePage(driver);

        // Launch Gigatron page
        gigatronHome.openGigatronURL();
        Thread.sleep(5000);

        // Accept cookies on Gigatron site
        gigatronHome.clickAcceptCookies();
        Thread.sleep(3000);

        // Find FB widgets
        boolean checkFbWidget = gigatronHome.fbWidgetsExist();
        Assert.assertEquals(checkFbWidget, true);
        Thread.sleep(3000);

        // Find Instagram widgets
        boolean checkInstWidget = gigatronHome.instWidgetsExist();
        Assert.assertEquals(checkInstWidget, true);
        Thread.sleep(3000);

        System.out.println("TEST PASSED: Gigatron social netowork widgets visible on site.");

        Thread.sleep(5000);
        driver.quit();

    }
}
